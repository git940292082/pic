package com.example.tupian.dao;

import java.io.Serializable;

public class MusicFile  implements Serializable{
	
	private static final long serialVersionUID =1L;
	/**
	 * 
	 */
	private String Name;
	private String Path;
	private String People;
	private boolean Playing;
	private int SumTime;
	private int Src;
	private int inTime;
	private String artist;
	private String album;
	private String album_key;
	private String album_art;
	
	
	/**
	 * @return the album_art
	 */
	public String getAlbum_art() {
		return album_art;
	}
	/**
	 * @param album_art the album_art to set
	 */
	public void setAlbum_art(String album_art) {
		this.album_art = album_art;
	}
	/**
	 * @return the album_key
	 */
	public String getAlbum_key() {
		return album_key;
	}
	/**
	 * @param album_key the album_key to set
	 */
	public void setAlbum_key(String album_key) {
		this.album_key = album_key;
	}
	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}
	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}
	/**
	 * @return the album
	 */
	public String getAlbum() {
		return album;
	}
	/**
	 * @param album the album to set
	 */
	public void setAlbum(String album) {
		this.album = album;
	}
	/**
	 * @return the inTime
	 */
	public int getInTime() {
		return inTime;
	}
	/**
	 * @param inTime the inTime to set
	 */
	public void setInTime(int inTime) {
		this.inTime = inTime;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return Name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return Path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		Path = path;
	}
	/**
	 * @return the people
	 */
	public String getPeople() {
		return People;
	}
	/**
	 * @param people the people to set
	 */
	public void setPeople(String people) {
		People = people;
	}
	/**
	 * @return the playing
	 */
	public boolean isPlaying() {
		return Playing;
	}
	/**
	 * @param playing the playing to set
	 */
	public void setPlaying(boolean playing) {
		Playing = playing;
	}
	/**
	 * @return the sumTime
	 */
	public int getSumTime() {
		return SumTime;
	}
	/**
	 * @param sumTime the sumTime to set
	 */
	public void setSumTime(int sumTime) {
		SumTime = sumTime;
	}
	/**
	 * @return the src
	 */
	public int getSrc() {
		return Src;
	}
	/**
	 * @param src the src to set
	 */
	public void setSrc(int src) {
		Src = src;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
