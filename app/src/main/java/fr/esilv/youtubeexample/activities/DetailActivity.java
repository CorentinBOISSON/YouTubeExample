package fr.esilv.youtubeexample.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import fr.esilv.youtubeexample.R;

public class DetailActivity extends AppCompatActivity {
	
	private static final String VIDEO_ID = "VIDEO_ID";
	private String videoId;
	private TextView textView;
	
	public static void start(Context context, String videoId) {
		Intent intent = new Intent(context, DetailActivity.class);
		intent.putExtra(VIDEO_ID, videoId);
		context.startActivity(intent);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		Intent intent = getIntent();
		if (intent != null) {
			videoId = intent.getStringExtra(VIDEO_ID);
		}
		
		textView = findViewById(R.id.textView);
		textView.setText(videoId);
		
		
	}
}
