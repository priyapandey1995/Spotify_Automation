package com.Spotify;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Api {
	public String token ="Bearer BQAUkQUmh0pSbvcw_6hc9o0nM9hQxGE7FnaRHyHIIiAFAeqjUnxsnTnnc8nn0WmDikV0ngOB1XbLtAVYc1gTQLimoc27xe8D_nmsfQtoUtaEJ71gOkOEOeTk1WmjD-PzOkodvsO0AN9PLBFef33ip9yepJyN4YSBquW3s1j7B6mC1w-C5nD4NbPDfg2Rxu_FbnfNH3nL4VkNKLUgQ_6MtgL_NEqxvsy5qpHi6mUlyDuhxVyfr0V93RotAHGDGZOnEHDpmMpjNIQ";
	//user profile
	@Test
	public void getUserProfile() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				 .header("Authorization",token)
				 .when()
				 .get("https://api.spotify.com/v1/me");
		         response.prettyPrint();
		         String name = response.path("display_name");
		         System.out.println("name is" + name);
		         response.then().assertThat().statusCode(200);
				 Assert.assertEquals(200, response.getStatusCode());
		         
			     
		
	}
	
	@Test
	public void getCurrentUsersProfile() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me");
				response.prettyPrint();
				response.then().assertThat().statusCode(200);
			    Assert.assertEquals(200, response.getStatusCode());
		
	}
	
	@Test
	public void createPlaylist() {
		Response response = given()
				.header("Accept","application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.body("{\"name\":\"New Playlist\",\"description\":\"New playlist description\",\"public\":false}")
				.when()
				.post("https://api.spotify.com/v1/users/31msjm2el6ngqexkgpycmuvyajc4/playlists");
			    response.prettyPrint();
			    String playlistId = response.path("id");
			    System.out.println("Playlist id" +playlistId);
			    response.then().assertThat().statusCode(201);
			    Assert.assertEquals(201, response.getStatusCode());
				
	}
	@Test
	public void addItemsToPlaylist() {
		Response response = given()
				.header("Accept", "application/json")
				.header("Content-Type","application/json")
				.header("Authorization",token)
				.body("{\"uris\":[\"spotify:track:4iV5W9uYEdYUVa79Axb7Rh\",\"spotify:track:1301WleyT98MSxVHPZCA6M\",\"spotify:episode:512ojhOuo1ktJprKbVcKyQ\"]}")
				.when()
				.post("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?uris=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh%2Cspotify%3Atrack%3A1301WleyT98MSxVHPZCA6M");
			    response.prettyPrint();
//			    
				
	}
	
	@Test
	public void getPlaylist() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))");
    response.prettyPrint();
    String name = response.path("owner.display_name");
    System.out.println("name is " + name);
    response.then().assertThat().statusCode(200);
    Assert.assertEquals(200, response.getStatusCode());
	
	}		
			
	@Test
	public void getUserPlaylist() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/users/31msjm2el6ngqexkgpycmuvyajc4/playlists?limit=10&offset=5");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);
    Assert.assertEquals(200, response.getStatusCode());
	
	}	
	
	@Test
	public void getCurrentUserPlaylist() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/me/playlists");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);
    Assert.assertEquals(200, response.getStatusCode());
	
	}	
	
	@Test
	public void getPlaylistCoverImage() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
    response.prettyPrint();
    // String height = response.path("height");
    //  System.out.println("height is" + height);
   
	}
	
	@Test
	public void getPlaylistItems() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/me/playlists");
    response.prettyPrint();
    String name = response.path("external_urls.spotify");
    System.out.println("name is" + name);
    response.then().assertThat().statusCode(200);
    Assert.assertEquals(200, response.getStatusCode());
	
	}
	
	@Test
	public void addCustomPlaylistCoverImage() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images");
    response.prettyPrint();
    response.then().assertThat().statusCode(401);
    Assert.assertEquals(401, response.getStatusCode());
	
	}
	
	@Test
	public void updatePlaylistItems() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.body("{\\\"range_start\\\":1,\\\"insert_before\\\":3,\\\"range_length\\\":2}")
	.when()
	.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks");
    response.prettyPrint();
    response.then().assertThat().statusCode(400);
    Assert.assertEquals(400, response.getStatusCode());
	
	}
	//show
	@Test
	public void getShow() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES");
    response.prettyPrint();
    response.then().assertThat().statusCode(200);
    Assert.assertEquals(200, response.getStatusCode());
	
	}
	
	@Test
	public void getSeveralShows() {
	Response response = given()
	.header("Accept","application/json")
	.header("Content-Type","application/json")
	.header("Authorization",token)
	.when()
	.get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
    response.prettyPrint();
//    response.then().assertThat().statusCode(200);
//    Assert.assertEquals(200, response.getStatusCode());
	
	}
	//search
	@Test
	public void searchForItem() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("q", "artist")
		.pathParam("type", "track")
		//.queryParam("q", "artist")
		//.queryParam("type", "track")
		.when()
		.get("https://api.spotify.com/v1/search?q={q}&type={type}");
		//.get("https://api.spotify.com/v1/search");//queryparam
	    response.prettyPrint();
	    response.then().assertThat().statusCode(200);
	    Assert.assertEquals(200, response.getStatusCode());
	}
	
	//Tracks
	
	@Test
	public void getTrack() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/tracks/4iV5W9uYEdYUVa79Axb7Rh");
	    response.prettyPrint();
	}
	
	@Test
	public void getSeveralTracks() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/tracks?ids=4iV5W9uYEdYUVa79Axb7Rh");
	    response.prettyPrint();
	}
	
	@Test
	public void getTracksAudioFeatures() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/audio-features/4iV5W9uYEdYUVa79Axb7Rh");
	    response.prettyPrint();
	}
	
	@Test
	public void getTracksAudioAnalysis() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/audio-analysis/4iV5W9uYEdYUVa79Axb7Rh");
	    response.prettyPrint();
	}
	
	//personalization
	
	@Test
	public void getUsersTopItems() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		//.pathParam("type", "artist")
		.when()
		.get("https://api.spotify.com/v1/me/top/artist");
	    response.prettyPrint();
	}
	
	//Markets
	@Test
	public void getAvaialbleMarkets() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/markets");
	    response.prettyPrint();
	}
	
	//follow
	
	@Test
	public void getFollowedArtist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("type", "artist")
		.when()
		.get("https://api.spotify.com/v1/me/following?type={type}");
	    response.prettyPrint();
	}
	
	@Test
	public void checkIfUsersFollowPlaylist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("ids", "jmperezperez%2Cthelinmichael%2Cwizzler")
		.when()
		.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids={ids}");
	    response.prettyPrint();
	}
	
	@Test
	public void checkIfUsersFollowArtistOrUsers() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("ids", "2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6")
		.when()
		.get("https://api.spotify.com/v1/me/following/contains?type=artist&ids={ids}");
	    response.prettyPrint();
	}
	
	@Test
	public void followPlaylist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.body("{\"public\":false}")
		.when()
		.put("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
	    response.prettyPrint();
	}
	@Test
	public void followArtistOrUsers() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.body("\"{ids:[\"74ASZWbe4lXaubB36ztrGX\", \"08td7MxkoHQkXnWAYD8d6Q\"]}")
		.when()
		.put("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	    response.prettyPrint();
	}
	
	//episode
	@Test
	public void getEpisode() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ");
	    response.prettyPrint();
	}
	@Test
	public void getSeveralEpisode() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
	    response.prettyPrint();
	}
	
	//chapters
	
	@Test
	public void getChapters() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
	    response.prettyPrint();
	}
	
	@Test
	public void getSeveralChapters() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/chapters/38bS44xjbVVZ3No3ByF1dJ");
	    response.prettyPrint();
	}
	//audiobooks
	@Test
	public void getAudiobooks() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ?market=ES");
	    response.prettyPrint();
	}
	
	@Test
	public void getSeveralAudiobooks() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	    response.prettyPrint();
	}
	
	@Test
	public void getAudiobooksChapters() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ/chapters");
	    response.prettyPrint();
	}
	
	//Artist
	@Test
	public void getArtist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
	    response.prettyPrint();
	}
	
	@Test
	public void getSeveralArtist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	    response.prettyPrint();
	}
	
	@Test
	public void getArtistsTopTrack() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks");
	    response.prettyPrint();
	}
	
	@Test
	public void getArtistsRelatedArtist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
	    response.prettyPrint();
	}
	
	@Test
	public void getArtistsAlbum() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums");
	    response.prettyPrint();
	}
	
	//albumns
	
	@Test
	public void getAlbum() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy");
	    response.prettyPrint();
	}
	
	@Test
	public void getSeveralAlbum() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
	    response.prettyPrint();
	}
	@Test
	public void getAlbumTracks() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks");
	    response.prettyPrint();
	}
	
	//browse
	@Test
	public void getRecommendations() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("seed_artists","4NHQUGzhtTLFvgF5SZesLK")
		.pathParam("seed_genres","classical,country")
		.pathParam("seed_tracks", "0c6xIDDpzE81m2q797ordA")
		.when()
		.get("https://api.spotify.com/v1/recommendations?seed_artists={seed_artists}&seed_genres={seed_genres}&seed_tracks={seed_tracks}");
	    response.prettyPrint();
	}
	@Test
	public void getNewRelases() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/browse/new-releases\"");
	    response.prettyPrint();
	}
	@Test
	public void getFeaturedPlaylist() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/browse/featured-playlists");
	    response.prettyPrint();
	}
	@Test
	public void getSingleBrowseCategory() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/browse/categories/");
	    response.prettyPrint();
	}
	@Test
	public void getSeveralBrowseCategory() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/browse/categories");
	    response.prettyPrint();
	}
	@Test
	public void getAvailableGenre() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
	    response.prettyPrint();
	}
	//Library
	@Test
	public void getUsersSavedTrack() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/tracks");
	    response.prettyPrint();
	}
	@Test
	public void getUsersSavedShows() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/shows");
	    response.prettyPrint();
	}
	@Test
	public void getUsersSavedEpisodes() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/episodes");
	    response.prettyPrint();
	}
	@Test
	public void getUsersSavedAudiobooks() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/audiobooks/contains?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	    response.prettyPrint();
	}
	@Test
	public void getUsersSavedAlbumns() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/albums/contains?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
	    response.prettyPrint();
	}
	@Test
	public void saveTracksForCurrentUser() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.put("https://api.spotify.com/v1/me/tracks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	    response.prettyPrint();
	}
	@Test
	public void saveShowsForCurrentUser() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.put("https://api.spotify.com/v1/me/shows?ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
	    response.prettyPrint();
	}
	@Test
	public void saveEpisodeForCurrentUser() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.put("https://api.spotify.com/v1/me/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf");
	    response.prettyPrint();
	}
	@Test
	public void saveAudiobookForCurrentUser() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.put("https://api.spotify.com/v1/me/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	    response.prettyPrint();
	}
	@Test
	public void saveAlbumnsForCurrentUser() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.put("https://api.spotify.com/v1/me/albums");
	    response.prettyPrint();
	}
	//player
	@Test
	public void addItemstoPlaybackQueue() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("uri", "spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh")
		.when()
		.post("https://api.spotify.com/v1/me/player/queue?uri={uri}");
	    response.prettyPrint();
	}
	@Test
	public void skipToPrevious() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.post("https://api.spotify.com/v1/me/player/previous");
	    response.prettyPrint();
	}
	@Test
	public void skipToNext() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.post("https://api.spotify.com/v1/me/player/next");
	    response.prettyPrint();
	}
	@Test
	public void pausePlayback() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.put("https://api.spotify.com/v1/me/player/pause");
	    response.prettyPrint();
	}
	@Test
	public void startOrResumePlayback() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.body("{\"context_uri\":\"spotify:album:5ht7ItJgpBH7W6vJ5BqpPr\",\"offset\":{\"position\":5},\"position_ms\":0}")
		.when()
		.put("https://api.spotify.com/v1/me/player/play");
	    response.prettyPrint();
	}
	@Test
	public void setRepeatMode() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("state", "context")
		.when()
		.put("https://api.spotify.com/v1/me/player/repeat?state={state}");
	    response.prettyPrint();
	}
	@Test
	public void seekToPosition() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("position_ms", 25000)
		.when()
		.put("https://api.spotify.com/v1/me/player/seek?position_ms={position_ms}");
	    response.prettyPrint();
	}
	@Test
	public void togglePlaybackShuffle() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("state", "true")
		.when()
		.put("https://api.spotify.com/v1/me/player/shuffle?state={state}");
	    response.prettyPrint();
	}
	@Test
	public void transferPlayback() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.body("{\"device_ids\":[\"74ASZWbe4lXaubB36ztrGX\"]}")
		.when()
		.put("https://api.spotify.com/v1/me/player");
	    response.prettyPrint();
	}
	@Test
	public void setPlaybackVolume() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.pathParam("volume_percent",50)
		.when()
		.put("https://api.spotify.com/v1/me/player/volume?volume_percent={volume_percent}");
	    response.prettyPrint();
	}
	@Test
	public void getUsersQueue() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/player/queue");
	    response.prettyPrint();
	}
	@Test
	public void getRecentlyPlayedTracks() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/player/recently-played");
	    response.prettyPrint();
	}
	@Test
	public void getPlaybackState() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/player");
	    response.prettyPrint();
	}
	@Test
	public void getAvailableDevices() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/player/devices");
	    response.prettyPrint();
	}
	@Test
	public void getCurrentlyPlayingTrack() {
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization",token)
		.when()
		.get("https://api.spotify.com/v1/me/player/currently-playing");
	    response.prettyPrint();
	}
	
	
	
			
			
			
			
			
			
			
			

}
