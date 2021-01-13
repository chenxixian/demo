package com.example.models;

public class Blog {
    private String _url;
    private String _title;
    private String _detail;

    public String getUrl() {
        return _url;
    }

    public String getTitle() {
        return _title;
    }

    public String getDetail() {
        return _detail;
    }

    public void setUrl(String url) {
        if (url.length() > 0 && (url.startsWith("http://") || url.startsWith("https://")))
            _url = url;
    }

    public void setTitle(String title) {
        if (title.length() > 0)
            _title = title;
    }

    public void setDetail(String detial) {
        if (detial.length() > 0)
            _detail = detial;
    }

	public void setSumary(String text) {
	}
}