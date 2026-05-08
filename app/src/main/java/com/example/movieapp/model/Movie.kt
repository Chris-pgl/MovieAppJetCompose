package com.example.movieapp.model

data class Movie(
    val id: String,
    val title: String,
    val year: String,
    val genre: String,
    val director: String,
    val actors: String,
    val plot: String,
    val poster: String,
    val images: List<String>,
    val rating: String)

fun getMovies(): List<Movie> {
    return listOf(
        Movie(id = "tt0499549",
            title = "Avatar",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he" +
                    "s part of.",
            poster = "https://m.media-amazon.com/images/M/MV5BMGE1OWZkZmItNmVhMC00YzAxLTgxOTctNjg3NWExM2RmOWJkXkEyXkFqcGc@._V1_.jpg",
            images = listOf("https://images-na.ssl-images-amazon.com/images/M/MV5BMjEyOTYyMzUxNl5BMl5BanBnXkFtZTcwNTg0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BNzM2MDk3MTcyMV5BMl5BanBnXkFtZTcwNjg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTY2ODQ3NjMyMl5BMl5BanBnXkFtZTcwODg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTMxOTEwNDcxN15BMl5BanBnXkFtZTcwOTg0MTUzNA@@._V1_SX1777_CR0,0,1777,999_AL_.jpg",
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTYxMDg1Nzk1MV5BMl5BanBnXkFtZTcwMDk0MTUzNA@@._V1_SX1500_CR0,0,1500,999_AL_.jpg"),
            rating = "7.9"),

        Movie(id = "tt0499548",
            title = "300",
            year = "2006",
            genre = "Action, Drama, Fantasy",
            director = "Zack Snyder",
            actors = "some actors",
            plot = "300 vs tropp roba",
            poster = "https://c8.alamy.com/compit/2jhdgjf/gerard-butler-poster-300-2006-2jhdgjf.jpg",
            images = listOf("https://c8.alamy.com/compit/2e3jggk/300-warner-bros-2006-film-con-gerard-butler-a-destra-2e3jggk.jpg",
                "https://media-assets.wired.it/photos/6183c7070877bbf917165588/master/pass/300.jpg",
                "https://istorica.it/wp-content/uploads/2022/11/sito-300.jpg"),
            rating = "8.9"),

        Movie(id = "tt0499559",
            title = "Harry Potter",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "etc",
            actors = "Janet McTeer, Zetc",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he" +
                    "s part of.",
            poster = "https://m.media-amazon.com/images/M/MV5BNDNkYmQ4NDMtZTI3ZS00NzkzLTk2OWUtN2I5MDcwYWQ1M2E5XkEyXkFqcGc@._V1_.jpg",
            images = listOf("https://www.illibraio.it/wp-content/uploads/2015/06/harrypotter.jpg",
                "https://hips.hearstapps.com/hmg-prod/images/schermata-2025-01-03-alle-14-00-53-6777df9113646.png?crop=0.556xw:1.00xh;0.372xw,0&resize=640:*",
                "https://freaking.news/wp-content/uploads/2023/02/Harry-Potter-Migliori-Film.jpg"),
            rating = "7.9"),

        Movie(id = "tt0499539",
            title = "Life",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "..",
            actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he" +
                    "s part of.",
            poster = "https://cinephellas.com/wp-content/uploads/2017/03/life-new-poster-1.jpg",
            images = listOf("https://www.rai.it/dl/img/2023/07/26/1600x900_1690388688812_geo%20-%202023-07-26T182740.583.jpg",
                "https://movieplayer.net-cdn.it/t/images/2017/03/07/life_ryan_reynolds_jpg_375x0_crop_q85.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJBd0sn8k6A2781OouvZYnv20zf2nt7eWoog&s"),
            rating = "7.9"),


        Movie(id = "tt0499541",
            title = "Matrix",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "Jam...",
            actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
            plot = "A paraplegic marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he" +
                    "s part of.",
            poster = "https://i5.walmartimages.com/seo/The-Matrix-Movie-Poster-Regular-Style-Size-24-X-36_c4539707-43cf-4d05-acd0-5ee19cb1eccb.db2e832b49bb7f682ca498f5aa3aa08f.jpeg",
            images = listOf("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQfHjLzAoNfcVifaPlhFi065LWIGrh1XWHN4g&s",
                "https://platform.theverge.com/wp-content/uploads/sites/2/chorus/uploads/chorus_asset/file/19084165/Trinity.jpeg?quality=90&strip=all&crop=19.208037825059,0,61.583924349882,100",
                "https://iadsb.tmgrup.com.tr/7204c2/1200/627/0/6/645/344?u=https://idsb.tmgrup.com.tr/2019/08/21/new-matrix-movie-announced-with-keanu-reeves-returning-as-neo-1566337894945.jpg"),
            rating = "7.9"),


        Movie(id = "tt0459541",
            title = "Inception",
            year = "2009",
            genre = "Action, Adventure, Fantasy",
            director = "James Cameron",
            actors = "Sam Worthington, Zoe Saldana, Sigourney Weaver, Stephen Lang",
            plot = "A aaaa marine dispatched to the moon Pandora on a unique mission becomes torn between following his orders and protecting the world he" +
                    "s part of.",
            poster = "https://stanzedicinema.com/wp-content/uploads/2010/06/inception_ver12_xlg.jpg",
            images = listOf("https://www.likeinamovie.it/wp-content/uploads/2025/11/inception-finale-film-nolan.png",
                "https://img.ilgcdn.com/sites/default/files/styles/social/public/foto/2023/01/03/Inception.jpg?_=1672744686",
                "https://scrittoridiscrittura.it/wp-content/uploads/2021/10/inception1-jpg.webp"),
            rating = "7.9"),



    )
}