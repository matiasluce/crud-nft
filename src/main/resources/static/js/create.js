function guardar() {
 
    let n = document.getElementById("txtNombre").value
    let i = document.getElementById("txtImg").value
    let p = parseInt(document.getElementById("txtPrecio").value)
 
    let nft = {
        nombre: n,
        imgurl: i,
        precio: p
    }        
    let url = "https://crud-nft-java.herokuapp.com/nfts"
    var options = {
        body: JSON.stringify(nft),
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
       // redirect: 'follow'
    }
    fetch(url, options)
        .then(function () {
            console.log("creado")
            alert("Grabado")
 
            // Handle response we get from the API
        })
        .catch(err => {
            //this.errored = true
            alert("Error al grabar" )
            console.error(err);
        })
}
