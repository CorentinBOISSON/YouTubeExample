package fr.esilv.youtubeexample.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

import java.util.List;

import fr.esilv.youtubeexample.R;
import fr.esilv.youtubeexample.adapters.YouTubeSearchItemAdapter;
import fr.esilv.youtubeexample.api.YouTubeService;
import fr.esilv.youtubeexample.models.YouTubeSearchItem;
import fr.esilv.youtubeexample.models.YouTubeSearchResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
	private static final String TAG = "MainActivity";
	private static final String API_KEY = "AIzaSyAt78poq3d_mR9waVNw-DYmMbvUQOu8N5Y";
	
	private EditText editText;
	private RecyclerView recyclerView;
	private YouTubeService service;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = findViewById(R.id.editText);
		
		recyclerView = findViewById(R.id.recyclerView);
		recyclerView.setLayoutManager(new LinearLayoutManager(this));
		
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("https://www.googleapis.com/youtube/v3/")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		
		service = retrofit.create(YouTubeService.class);
		
		editText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				if (s.length() >= 0) {
					launchSearch(s.toString());
				} else {
					launchSearch("");
				}
			}
			
			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		
	}
	
	private void launchSearch(String query) {
		service.search(query, API_KEY).enqueue(new Callback<YouTubeSearchResponse>() {
			@Override
			public void onResponse(@NonNull Call<YouTubeSearchResponse> call, @NonNull Response<YouTubeSearchResponse> response) {
				Log.d(TAG, "onResponse");
				if (response.isSuccessful()) {
					YouTubeSearchResponse youTubeSearchResponse = response.body();
					List<YouTubeSearchItem> itemList = youTubeSearchResponse.getItems();
					recyclerView.setAdapter(new YouTubeSearchItemAdapter(itemList));
				}
			}
			
			@Override
			public void onFailure(Call<YouTubeSearchResponse> call, Throwable t) {
				Log.e(TAG, "onFailure", t);
			}
		});
	}
	
}
