import java.io.*;
import java.util.*;

import org.farng.mp3.*;

public class ModelMusicManager extends Observable
{
	//CONSTANTS
	
	//GLOBAL VARIABLES
	private ViewMusicManager view;
	private File mainFolder;
	private MagicList<CustomMP3File> files;
	
	//CONSTRUCTORS
	public ModelMusicManager(ViewMusicManager view)
	{
		this.view = view;
		addObserver(view);
	}
	
	//OVERRIDES
	
	//METHODS
	public void addFile(String file) throws IOException, TagException
	{
		files.add(new CustomMP3File(file));
	}
	public void removeFile(int index) { files.remove(index); }
	public void removeAll() { files.clear(); }
	public void renameFile(int index, String newName) { files.get(index).setNewName(newName); }
	public CustomMP3File getFile(int index) { return files.get(index); }
	public String[] getSubFoldersNames()
	{
		File[] subFolders;
		String[] subFoldersNames;
		
		subFolders = mainFolder.listFiles();
		subFoldersNames = new String[subFolders.length];
		for (int i = 0; i < subFoldersNames.length; i++)
			subFoldersNames[i] = subFolders[i].getName();
		
		return subFoldersNames;
	}
	public void insertIntoLibrary(String folder) throws IOException, TagException
	{
		File outFolder;
		ID3TagData currentID3;
		String[] splitted;
		CustomMP3File currentFile;
		
		outFolder = new File(mainFolder, folder);
		for (Object file : files.toArray())
		{
			currentFile = (CustomMP3File)file;
			currentID3 = currentFile.getID3TagData();
			currentID3.setGenre(folder);
			if (currentFile.getNewName().contains(" - "))
			{
				splitted = currentFile.getNewName().split(" - ");
				currentID3.setTitle(splitted[1]);
				currentID3.setArtist(splitted[0]);
			}
			else
			{
				currentID3.setTitle(currentFile.getNewName());
				currentID3.setArtist("");
			}
			currentFile.applyID3TagData();
			currentFile.renameTo(new File(outFolder, currentFile.getNewName()));
		}
	}
	public void adjustTags(String folder) throws IOException, TagException
	{
		CustomMP3File currentFile;
		ID3TagData currentID3;
		String[] splitted;
		
		for (File file : new File(folder).listFiles())
		{
			currentFile = new CustomMP3File(file);
			currentID3 = currentFile.getID3TagData();
			currentID3.setGenre(folder);
			if (currentFile.getName().contains(" - "))
			{
				splitted = currentFile.getName().split(" - ");
				currentID3.setTitle(splitted[1]);
				currentID3.setArtist(splitted[0]);
			}
			else
			{
				currentID3.setTitle(currentFile.getName());
				currentID3.setArtist("");
			}
			currentFile.applyID3TagData();
		}
	}
}