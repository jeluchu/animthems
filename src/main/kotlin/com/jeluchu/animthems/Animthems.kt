package com.jeluchu.animthems

import com.jeluchu.animthems.core.connection.RestClient
import com.jeluchu.animthems.models.animes.details.request.AnimeDetailsRequestEntity
import com.jeluchu.animthems.models.animes.details.response.AnimeDetailsEntity
import com.jeluchu.animthems.models.animes.list.request.AnimesRequestEntity
import com.jeluchu.animthems.models.animes.list.response.AnimesEntity
import com.jeluchu.animthems.models.artists.details.request.ArtistDetailsRequestEntity
import com.jeluchu.animthems.models.artists.details.response.ArtistDetailsEntity
import com.jeluchu.animthems.models.artists.list.response.ArtistsEntity
import com.jeluchu.animthems.models.artists.list.request.ArtistsRequestEntity
import com.jeluchu.animthems.models.random.response.RandomVideoEntity
import com.jeluchu.animthems.models.random.request.RandomVideoRequestEntity

object Animthems {
    private var restClient = RestClient()

    /**
     * Function to get animes with image.
     * @return List of animes
     * @see AnimesEntity
     */
    suspend fun getAnimes(
        page: Int = 1,
    ): List<AnimesEntity> {
        val endpoint = "anime"
        val params = mutableListOf<String>()

        params.add("page[number]=$page")
        params.add("page[size]=100")
        params.add("include=images")

        return restClient.request<AnimesRequestEntity>("$endpoint?${params.joinToString("&")}")?.anime?.map { anime ->
            anime.toAnimesEntity()
        }.orEmpty()
    }

    /**
     * Function to get animes with image.
     * @return List of animes
     * @see AnimesEntity
     */
    suspend fun getAnimesFiltered(
        page: Int = 1,
        year: Int? = null,
        season: String? = null
    ): List<AnimesEntity> {
        val endpoint = "anime"
        val params = mutableListOf<String>()

        params.add("page[number]=$page")
        params.add("page[size]=100")
        params.add("include=images")
        year?.let { params.add("filter[year]=$it") }
        season?.let { params.add("filter[season]=$it") }

        return restClient.request<AnimesRequestEntity>("$endpoint?${params.joinToString("&")}")?.anime?.map { anime ->
            anime.toAnimesEntity()
        }.orEmpty()
    }

    /**
     * Function to get anime details.
     * @return Anime details
     * @see AnimeDetailsEntity
     */
    suspend fun getAnime(
        slug: String,
    ): AnimeDetailsEntity? {
        val endpoint = "anime/$slug"
        val params = mutableListOf<String>()

        params.add("include=animethemes.animethemeentries.videos,images")

        return restClient.request<AnimeDetailsRequestEntity>("$endpoint?${params.joinToString("&")}")?.anime?.toAnimeDetails()
    }

    /**
     * Function to get artists with image.
     * @return List of artists
     * @see ArtistsEntity
     */
    suspend fun getArtists(
        page: Int = 1,
    ): List<ArtistsEntity> {
        val endpoint = "artist"
        val params = mutableListOf<String>()

        params.add("page[number]=$page")
        params.add("page[size]=100")
        params.add("include=images")

        val fullEndpoint = if (params.isNotEmpty()) "$endpoint?${params.joinToString("&")}"
        else endpoint

        return restClient.request<ArtistsRequestEntity>(fullEndpoint)?.artists?.map { artist ->
            artist.toArtistEntity()
        }.orEmpty()
    }

    /**
     * Function to get artist details.
     * @return Artist details
     * @see ArtistDetailsEntity
     */
    suspend fun getArtist(
        slug: String,
    ): ArtistDetailsEntity? {
        val endpoint = "artist/$slug"
        val params = mutableListOf<String>()

        params.add(
            "include=groups," +
                    "images," +
                    "members," +
                    "resources," +
                    "songs," +
                    "songs.animethemes.animethemeentries.videos," +
                    "songs.animethemes.anime,songs.animethemes.group," +
                    "songs.animethemes.animethemeentries.videos.audio"
        )

        val fullEndpoint = "$endpoint?${params.joinToString("&")}"
        return restClient.request<ArtistDetailsRequestEntity>(fullEndpoint)?.artist?.toArtistDetails()
    }

    /**
     * Function to get random video.
     * @return Link of video and possibly audio link
     * @see RandomVideoEntity
     */
    suspend fun getRandomVideo(): RandomVideoEntity? {
        val endpoint = "video"
        val params = mutableListOf<String>()

        params.add("sort=random")
        params.add("page[size]=1")
        params.add("include=animethemeentries.animetheme.anime")

        return restClient.request<RandomVideoRequestEntity>("$endpoint?${params.joinToString("&")}")?.videos?.map { artist ->
            artist.toRandomVideoEntity()
        }?.first()
    }

    /**
     * Function to get year index.
     * @return List of years
     * @see Int in List<T>
     */
    suspend fun getYearsIndex() = restClient.request<List<Int>>("animeyear").orEmpty()
}