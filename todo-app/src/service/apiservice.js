import axios from 'axios'

const baseUrl= process.env.REACT_APP_API_URL

const httpClient = axios.create({
    baseURL: 'http://localhost:8080',
    withCredentials: false,
    headers: {
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*', // Adicionar cabeçalhos CORS
    }
});


class ApiService {

    constructor(apiurl){
        this.apiurl = apiurl;
    }




    post(url, objeto){
        const requestUrl = `${this.apiurl}${url}`
        console.log(requestUrl)
        return httpClient.post(requestUrl, objeto);
    }

    put(url, objeto){
        const requestUrl = `${this.apiurl}${url}`
        return httpClient.put(requestUrl, objeto);
    }

    delete(url){
        const requestUrl = `${this.apiurl}${url}`
        return httpClient.delete(requestUrl)
    }

    get(url){
        const requestUrl = `${this.apiurl}${url}`
        return httpClient.get(requestUrl)
    }
}

export default ApiService;