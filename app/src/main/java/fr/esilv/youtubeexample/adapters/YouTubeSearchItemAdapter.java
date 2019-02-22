package fr.esilv.youtubeexample.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fr.esilv.youtubeexample.R;
import fr.esilv.youtubeexample.viewholders.SearchItemViewHolder;
import fr.esilv.youtubeexample.models.YouTubeSearchItem;

public class YouTubeSearchItemAdapter extends RecyclerView.Adapter<SearchItemViewHolder> {
	
	private final List<YouTubeSearchItem> items;
	
	public YouTubeSearchItemAdapter(List<YouTubeSearchItem> items) {
		this.items = items;
	}
	
	@NonNull
	@Override
	public SearchItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
		View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_search_item, viewGroup, false);
		return new SearchItemViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull SearchItemViewHolder searchItemViewHolder, int position) {
		searchItemViewHolder.bind(items.get(position));
	}
	
	@Override
	public int getItemCount() {
		return items != null ? items.size() : 0;
	}
}
