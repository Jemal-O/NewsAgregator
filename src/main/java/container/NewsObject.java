package container;

public class NewsObject {
	private String author;
	private String link;
	private String guid;
	private String description;
	private String title;
	private String pubDate;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[author: ");
		builder.append(author);
		builder.append(", link: ");
		builder.append(link);
		builder.append(", guid: ");
		builder.append(guid);
		builder.append(", description: ");
		builder.append(description);
		builder.append(", title: ");
		builder.append(title);
		builder.append(", pubDate: ");
		builder.append(pubDate + "]");
		return builder.toString();
	}
}



