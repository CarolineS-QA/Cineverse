//Individual movie page info - copied from GallerySearch.js

function getOurMovie() {
    let movieId = sessionStorage.getItem("movieId");

    axios.get(`http://www.omdbapi.com/?apikey=c737e3a5&i=` + movieId)
        .then((response) => {
            console.log(response.data);
            let movie = response.data;

            let output = `
            <div class="row">
                <div class="col-md-4">
                    <img src="${movie.Poster}" class="thumbnail" alt="\`${movie.Title}'s Movie Poster\`">
                </div>
                <div class="col-md-8">
                    <h2>${movie.Title}</h2>
                    <ul class="list-group">
                        <li class="list-group-item"><strong>Genre:</strong> ${movie.Genre}</li>
                        <li class="list-group-item"><strong>Released:</strong> ${movie.Released}</li>
                        <li class="list-group-item"><strong>Rated:</strong> ${movie.Rated}</li>
                        <li class="list-group-item"><strong>IMDB Rating:</strong> ${movie.imdbRating}</li>
                        <li class="list-group-item"><strong>Director:</strong> ${movie.Director}</li>
                        <li class="list-group-item"><strong>Writer:</strong> ${movie.Writer}</li>
                        <li class="list-group-item"><strong>Actors:</strong> ${movie.Actors}</li>
                    </ul>
                </div>
            </div>

            <div>
                <div class="row">
                    <div class="well">
                        <h3>Plot</h3>
                        ${movie.Plot}
                        <hr>
                        <a href="\`https://idmdb.com/title/${movie.imdbID}\`" target="_blank" class="btn btn-primary">View on IMDB</a>
                        <a href="gallarySearch.html" class="btn btn-default">Search another movie</a>
                    </div>
            </div>
            `;

            $("#movieDiv").html(output);
        })


        .catch((err) => {
            console.log(err);
            window.alert("Oops, something went wrong...");
        });

}

