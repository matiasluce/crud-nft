if (document.getElementById("app")){
    const app=new Vue({
        el:"#app",
        data(){
            return{
            nfts:[],
            errored:false,
            loading:true,
            }
        },
        created(){
            var url="http://localhost:8080/nfts"
            this.fetchData(url);
        },
        methods:{
            fetchData(url) {
                fetch(url)
                    .then(response => response.json())
                    .then(data => {
                        this.nfts = data;
                        this.loading = false;
                    })
                    .catch(err => {
                        this.errored = true
                    })
            },
            eliminar(nft) {
                const url = 'http://localhost:8080/nfts/' + nft;
                var options = {
                    method: 'DELETE',
                }
                fetch(url, options)
                    .then(res => res.text()) // or res.json()
                    .then(res => {
                        location.reload();
                    })
            }
        }
    })
}
