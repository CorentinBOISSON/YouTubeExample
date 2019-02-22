package fr.esilv.youtubeexample.models;

public class Snippet {
	private String title;
	private String description;
	private Thumbnails thumbnails;
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getThumbnailUrl() {
		return thumbnails.getMedium().getUrl();
	}
}
