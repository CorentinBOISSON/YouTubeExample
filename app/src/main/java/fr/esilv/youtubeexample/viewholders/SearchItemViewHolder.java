package fr.esilv.youtubeexample.viewholders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import fr.esilv.youtubeexample.R;
import fr.esilv.youtubeexample.activities.DetailActivity;
import fr.esilv.youtubeexample.models.Snippet;
import fr.esilv.youtubeexample.models.YouTubeSearchItem;

public class SearchItemViewHolder extends RecyclerView.ViewHolder {
	
	private TextView title;
	private TextView description;
	private ImageView thumbnail;
	
	public SearchItemViewHolder(@NonNull View itemView) {
		super(itemView);
		this.title = itemView.findViewById(R.id.title);
		this.description = itemView.findViewById(R.id.description);
		this.thumbnail = itemView.findViewById(R.id.thumbnail);
	}
	
	public void bind(final YouTubeSearchItem youTubeSearchItem) {
		final Snippet snippet = youTubeSearchItem.getSnippet();
		title.setText(snippet.getTitle());
		description.setText(snippet.getDescription());
		
		Glide.with(itemView).load(snippet.getThumbnailUrl()).into(thumbnail);
		
		itemView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				DetailActivity.start(v.getContext(), youTubeSearchItem.getId().getVideoId());
			}
		});
	}
}
