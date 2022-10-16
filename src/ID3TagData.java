import java.awt.image.*;

public class ID3TagData
{
	private String title;
	private String artist;
	private String genre;
	private int year;
	private String album;
	private int trackNumber;
	private BufferedImage albumCover;
	
	public ID3TagData(String title, String artist, String genre, int year, String album, int trackNumber, BufferedImage albumCover)
	{
		this.title = title;
		this.artist = artist;
		this.genre = genre;
		this.year = year;
		this.album = album;
		this.trackNumber = trackNumber;
		this.albumCover = albumCover;
	}
	public ID3TagData(String title, String artist, String genre, int year, String album, int trackNumber)
	{ this(title, artist, genre, year, album, trackNumber, null); }
	public ID3TagData(String title, String artist, String genre, int year, String album)
	{ this(title, artist, genre, year, album, -1); }
	public ID3TagData(String title, String artist, String genre, int year)
	{ this(title, artist, genre, year, null); }
	public ID3TagData(String title, String artist, String genre)
	{ this(title, artist, genre, -1); }
	public ID3TagData() { this(null, null, null); }

	public String getTitle() { return title; }
	public String getArtist() { return artist; }
	public String getGenre() { return genre; }
	public int getYear() { return year; }
	public String getAlbum() { return album; }
	public int getTrackNumber() { return trackNumber; }
	public BufferedImage getAlbumCover() { return albumCover; }

	public void setTitle(String title) { this.title = title; }
	public void setArtist(String artist) { this.artist = artist; }
	public void setGenre(String genre) { this.genre = genre; }
	public void setYear(int year) { this.year = year; }
	public void setAlbum(String album) { this.album = album; }
	public void setTrackNumber(int trackNumber) { this.trackNumber = trackNumber; }
	public void setAlbumCover(BufferedImage albumImage) { this.albumCover = albumImage; }
}