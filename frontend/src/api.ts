
/**
 * This service implements functionality to make api calls through open api generated client
 * We are adding custom axios instance which helps customize the generated client with interceptors and more axios functionalities
 */
import { ConnstoreApi } from "./api/connectionstore";
import { ConnectionApi } from "./api/connection";
import { AuthApi } from "./api/authentication";

import axios from "axios";

// Create axios instance
const axiosInstance = axios.create();

// Configuration and base path are not provided
const connstoreApiService = new ConnstoreApi(undefined, process.env.REACT_APP_APISERVER+"/connstore", axiosInstance);
const connectionApiService = new ConnectionApi(undefined, process.env.REACT_APP_APISERVER+"/connection", axiosInstance);
const authApiService = new AuthApi(undefined, process.env.REACT_APP_APISERVER+"/auth", axiosInstance);

console.log(process.env.REACT_APP_APISERVER+"/connstore");
export { connstoreApiService, connectionApiService, authApiService, axiosInstance };