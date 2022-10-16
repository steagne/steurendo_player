import java.io.*;
import org.farng.mp3.*;
import org.farng.mp3.id3.*;

public class EasyID3
{
	private File file;
	private MP3File mp3File;
	
	public EasyID3(File file)
	{
		try
		{
			if (file.exists())
			{
				this.file = file;
				mp3File = new MP3File(file);
			}
		}
		catch (Exception ex) { ex.printStackTrace(); }
	}
	public EasyID3(String filename) { this(new File(filename)); }
	
	public void setFile(File file)
	{
		if (file.exists())
		{
			this.file = file;
			mp3File.setMp3file(file);
		}
	}
	public void renameTo(File file)
	{
		this.file.renameTo(file);
		mp3File.setMp3file(file);
	}
	private void setFrame(AbstractID3v2FrameBody frame)
	{
		AbstractID3v2 id3;
		AbstractID3v2Frame id3Frame;
		
		id3 = mp3File.getID3v2Tag();
		id3Frame = new ID3v2_4Frame(frame);
		id3.setFrame(id3Frame);
	}
	public void clearID3()
	{
	}
	public void test(String text)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTIT1((byte)0, text);
		setFrame(frame);
	}
	public void setTitle(String title)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTIT2((byte)0, title);
		setFrame(frame);
	}
	private void setTrackNumber(int trackNumber)
	{
	}
	public void setYear(int year)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTRCK((byte)0, "" + year);
		setFrame(frame);
	}
	public void setGenre(String genre)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTCON((byte)0, genre);
		setFrame(frame);
	}
	public void setArtist(String artist)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTPE1((byte)0, artist);
		setFrame(frame);
	}
	public void setAlbum(String album)
	{
		AbstractID3v2FrameBody frame;
		
		frame = new FrameBodyTALB((byte)0, album);
		setFrame(frame);
	}
	private void setAlbumCover(File cover)
	{
	}
	
	public void save()
	{
		try
		{
			mp3File.save();
		} catch (Exception e) { e.printStackTrace(); }
	}
}