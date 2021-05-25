package rmit.fotogram;

public class ImagePost {
    private final String img_src;
    private final String[] download_urls;
    private final String username;
    private final int likes;
    private final String[] tags;
    private final String description;


    ImagePost(String img_src, String[] download_urls, String username, int likes, String[] tags, String description) {
        this.img_src = img_src;
        this.download_urls = download_urls;
        this.username = username;
        this.likes = likes;
        this.tags = tags;
        this.description = description;
    }

    public String getImg_src () {        return img_src;
    }

    public String[] getDownload_urls () {
        return download_urls;
    }

    public String getUsername () {
        return username;
    }

    public int getLikes () {
        return likes;
    }

    public String[] getTags () {
        return tags;
    }

    public String getDescription () {
        return description;
    }
}
