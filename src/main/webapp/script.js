run();
function run(){
    var url = "http://localhost:8084/RestJaxRsEx2/api/person/";
    var conf = {method: "get"};
    var promise = fetch(url,conf);
    promise.then(function(response){
        return response.text();
    }).then(function(text){
 text = document.getElementById("hey");
    });

}
