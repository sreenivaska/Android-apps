package com.enlume.examples.imagelist;

public class ImageAndText {
	private String imageUrl;
	private String text;
	public ImageAndText(String text) {
		this.imageUrl = "/drawable/icon.png";
	    this.text = text;
	}
	public String getImageUrl() {
	    return imageUrl;
	}
	public String getText() {
	    return text;
	}
}
