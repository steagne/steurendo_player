import java.awt.image.*;
import java.io.*;

import org.farng.mp3.*;
import org.farng.mp3.id3.*;

public class CustomMP3File extends MP3File
{
	private String newName;
	private ID3TagData id3; 
	
	public CustomMP3File(String filename) throws IOException, TagException
	{
		super(filename);
		
		newName = filename;
	}
	public CustomMP3File(File file) throws IOException, TagException
	{
		super(file);
		
		newName = file.getName();
	}
	public CustomMP3File(File file, boolean bool) throws IOException, TagException
	{
		super(file, bool);
		
		newName = file.getName();
	}
	public CustomMP3File(MP3File file)
	{
		super(file);
		
		newName = file.getMp3file().getName();
	}
	public CustomMP3File() { super(); }
	
	public String getNewName() { return newName; }
	public ID3TagData getID3TagData() { return id3; }
	public String getName() { return getMp3file().getName(); }
	
	public void setNewName(String newName) { this.newName = newName; }
	public void setID3TagData(ID3TagData id3) { this.id3 = id3; }
	
	public void applyID3TagData() throws IOException, TagException
	{
		setTitle(id3.getTitle());
		setArtist(id3.getArtist());
		setGenre(id3.getArtist());
		setYear(id3.getYear());
		setAlbum(id3.getAlbum());
		setTrackNumber(id3.getTrackNumber());
		setAlbumCover(id3.getAlbumCover());
		save();
	}
	public void renameTo(File file) { getMp3file().renameTo(file); }
	
	//PRIVATE METHODS
	private void setFrame(AbstractID3v2FrameBody frame)
	{
		AbstractID3v2 id3;
		AbstractID3v2Frame id3Frame;
		
		id3 = getID3v2Tag();
		id3Frame = new ID3v2_4Frame(frame);
		id3.setFrame(id3Frame);
	}
	private void setTitle(String title)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTIT2((byte)0, title);
		setFrame(frame);
	}
	private void setTrackNumber(int trackNumber)
	{
	}
	private void setYear(int year)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTRCK((byte)0, "" + year);
		setFrame(frame);
	}
	private void setGenre(String genre)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTCON((byte)0, genre);
		setFrame(frame);
	}
	private void setArtist(String artist)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTPE1((byte)0, artist);
		setFrame(frame);
	}
	private void setAlbum(String album)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTALB((byte)0, album);
		setFrame(frame);
	}
	private void setAlbumCover(BufferedImage cover)
	{
	}
}