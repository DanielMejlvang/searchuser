function greeting() {
    console.log("Hello from functions.js");
}

function preventFormFromSending(searchform) {
    searchform.submit(function (event) {
        event.preventDefault();
        searchUser($("#username").val())
    })
}

function searchUser(username) {
    console.log("Search user called with " + username);
    //AJAX request
    var searchObject = {};
    searchObject["username"] = username;
    $.ajax({
        url:"/api/search",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(searchObject),
        success:function (data) {
            console.log("Success!");
            $("#status").html(data.message);
            $.each(data.userList, function (index, value) {
                $("#userList").append("<div>" + value.username + "</div>")
            })
        },
        error:function (data) {
            console.log("error...");
        }
    });
}

function newsForm(createForm) {
    createForm.submit(function (event) {
        event.preventDefault();
        console.log("Creating news...");
        generateNews($("#header").val())
    })
}

function generateNews(header) {
    var news = {};
    news["header"] = header;
    //ajax
    $.ajax({
        url:"/api/news",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(news),
        success:function (data) {
            // console.log("Success!");
            // $("#timeline").html(data.message);
            // $.each(data.timeline, function (index, value) {
            //     console.log("Why are you like this")
            //     if ($("#timeline").contains(value.header)) {
            //         $("#timeline").prepend(value.header + "<br>")
            //         console.log("Add")
            //     } else {
            //         $("#timeline").prepend("<div>"+ fail + "</div>")
            //         console.log("Fail")
            //     }
            // })
        },
    })
}

function getNewsForm(find) {
    find.submit(function (event) {
        event.preventDefault();
        console.log("Manual fetch...");
        getLatest();
    })
}

// setInterval(function () {
//     console.log("Fetching latest news...");
//     getLatest();
// }, 3000);

function getLatest() {
    var what = {};
    $.ajax({
        url:"/api/get",
        type:"POST",
        contentType:"application/JSON",
        data: JSON.stringify(what),
        success:function (data) {
            $.each(data.timeline, function (index, value) {
                $("#timeline").prepend("<div>" + value.header + "</div>")
            })
        },
        error:function (data) {
            console.log("error...latest or something");
        }
    })
}

function checkjQuery() {
    if(typeof jQuery != undefined) {
        console.log("jQuery has been loaded.")
    } else {
        console.log("jQuery has NOT been loaded.")
    }
}