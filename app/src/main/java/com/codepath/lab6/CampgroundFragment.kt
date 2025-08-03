
package com.codepath.lab6

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
import org.json.JSONException

private const val TAG = "CampgroundFragment"
private const val CAMPGROUND_URL =
    "https://developer.nps.gov/api/v1/campgrounds"

class CampgroundFragment : Fragment() {

    private val campgrounds = mutableListOf<Campground>()
    private lateinit var campgroundsRecyclerView: RecyclerView
    private lateinit var campgroundAdapter: CampgroundAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(
            R.layout.fragment_campground,
            container,
            false
        )

        campgroundsRecyclerView =
            view.findViewById(R.id.campground_recycler_view)

        campgroundsRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())
        campgroundsRecyclerView.setHasFixedSize(true)

        campgroundAdapter =
            CampgroundAdapter(requireContext(), campgrounds)
        campgroundsRecyclerView.adapter = campgroundAdapter

        fetchCampgrounds()

        return view
    }

    private fun fetchCampgrounds() {
        val client = AsyncHttpClient()

        val url = "$CAMPGROUND_URL?api_key=${BuildConfig.API_KEY}"

        client.get(url, object : JsonHttpResponseHandler() {

            override fun onFailure(
                statusCode: Int,
                headers: Headers?,
                response: String?,
                throwable: Throwable?
            ) {
                Log.e(TAG, "Failed to fetch campgrounds: $statusCode", throwable)
            }

            override fun onSuccess(
                statusCode: Int,
                headers: Headers,
                json: JSON
            ) {
                Log.i(TAG, "Successfully fetched campgrounds")

                try {
                    val parsedJson = createJson().decodeFromString(
                        CampgroundResponse.serializer(),
                        json.jsonObject.toString()
                    )

                    parsedJson.data?.let { list ->
                        campgrounds.clear()
                        campgrounds.addAll(list)
                        campgroundAdapter.notifyDataSetChanged()
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "Failed to parse campgrounds response", e)
                }
            }
        })
    }
}
