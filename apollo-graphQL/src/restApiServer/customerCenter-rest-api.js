import {RESTDataSource} from 'apollo-datasource-rest';

class customerCenterRestApi extends RESTDataSource {
    constructor() {
        super();
        // dev for Local
            this.baseURL = 'http://localhost:8085';
        // dev for IDE
            // this.baseURL = 'http://8085-ide-xxxxxxxxxx.kuberez.io'
        // prod
            // this.baseURL = 'https://customer-center:8080';
    }


    stringToJson(str){
        if(typeof str == 'string'){
            str = JSON.parse(str);
        }
        return str;
    }
}

export default customerCenterRestApi;




