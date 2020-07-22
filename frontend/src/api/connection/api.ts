// tslint:disable
/// <reference path="./custom.d.ts" />
/**
 * Connector Service
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * OpenAPI spec version: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


import * as url from "url";
import { Configuration } from "./configuration";
import globalAxios, { AxiosPromise, AxiosInstance } from 'axios';

const BASE_PATH = "http://api/connector".replace(/\/+$/, "");

/**
 *
 * @export
 */
export const COLLECTION_FORMATS = {
    csv: ",",
    ssv: " ",
    tsv: "\t",
    pipes: "|",
};

/**
 *  
 * @export
 * @interface RequestArgs
 */
export interface RequestArgs {
    url: string;
    options: any;
}

/**
 * 
 * @export
 * @class BaseAPI
 */
export class BaseAPI {
    protected configuration: Configuration | undefined;

    constructor(configuration?: Configuration, protected basePath: string = BASE_PATH, protected axios: AxiosInstance = globalAxios) {
        if (configuration) {
            this.configuration = configuration;
            this.basePath = configuration.basePath || this.basePath;
        }
    }
};

/**
 * 
 * @export
 * @class RequiredError
 * @extends {Error}
 */
export class RequiredError extends Error {
    name: "RequiredError" = "RequiredError";
    constructor(public field: string, msg?: string) {
        super(msg);
    }
}

/**
 * 
 * @export
 * @interface Connection
 */
export interface Connection {
    /**
     * 
     * @type {string}
     * @memberof Connection
     */
    id: string;
    /**
     * 
     * @type {string}
     * @memberof Connection
     */
    hostname: string;
    /**
     * 
     * @type {number}
     * @memberof Connection
     */
    port: number;
    /**
     * 
     * @type {string}
     * @memberof Connection
     */
    username: string;
    /**
     * 
     * @type {string}
     * @memberof Connection
     */
    password: string;
    /**
     * 
     * @type {string}
     * @memberof Connection
     */
    session: string;
}

/**
 * 
 * @export
 * @interface ConnectionCommandRequest
 */
export interface ConnectionCommandRequest {
    /**
     * 
     * @type {string}
     * @memberof ConnectionCommandRequest
     */
    storeId: string;
    /**
     * 
     * @type {string}
     * @memberof ConnectionCommandRequest
     */
    command: string;
    /**
     * 
     * @type {string}
     * @memberof ConnectionCommandRequest
     */
    token: string;
}

/**
 * 
 * @export
 * @interface ConnectionCommandResponse
 */
export interface ConnectionCommandResponse {
    /**
     * 
     * @type {string}
     * @memberof ConnectionCommandResponse
     */
    response: string;
}

/**
 * 
 * @export
 * @interface ConnectionRequest
 */
export interface ConnectionRequest {
    /**
     * 
     * @type {string}
     * @memberof ConnectionRequest
     */
    id: string;
    /**
     * 
     * @type {string}
     * @memberof ConnectionRequest
     */
    token: string;
    /**
     * 
     * @type {string}
     * @memberof ConnectionRequest
     */
    password: string;
}

/**
 * 
 * @export
 * @interface ConnectionStatus
 */
export interface ConnectionStatus {
    /**
     * 
     * @type {number}
     * @memberof ConnectionStatus
     */
    statuscode?: number;
}

/**
 * 
 * @export
 * @interface DestroyConnectionRequest
 */
export interface DestroyConnectionRequest {
    /**
     * 
     * @type {string}
     * @memberof DestroyConnectionRequest
     */
    storeId: string;
    /**
     * 
     * @type {string}
     * @memberof DestroyConnectionRequest
     */
    token: string;
}


/**
 * ConnectionApi - axios parameter creator
 * @export
 */
export const ConnectionApiAxiosParamCreator = function (configuration?: Configuration) {
    return {
        /**
         * 
         * @summary AddCommand
         * @param {ConnectionCommandRequest} connectionCommandRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addCommand(connectionCommandRequest: ConnectionCommandRequest, options: any = {}): RequestArgs {
            // verify required parameter 'connectionCommandRequest' is not null or undefined
            if (connectionCommandRequest === null || connectionCommandRequest === undefined) {
                throw new RequiredError('connectionCommandRequest','Required parameter connectionCommandRequest was null or undefined when calling addCommand.');
            }
            const localVarPath = `/connection`;
            const localVarUrlObj = url.parse(localVarPath, true);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = Object.assign({ method: 'PUT' }, baseOptions, options);
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            localVarHeaderParameter['Content-Type'] = 'application/json';

            localVarUrlObj.query = Object.assign({}, localVarUrlObj.query, localVarQueryParameter, options.query);
            // fix override query string Detail: https://stackoverflow.com/a/7517673/1077943
            delete localVarUrlObj.search;
            localVarRequestOptions.headers = Object.assign({}, localVarHeaderParameter, options.headers);
            const needsSerialization = (<any>"ConnectionCommandRequest" !== "string") || localVarRequestOptions.headers['Content-Type'] === 'application/json';
            localVarRequestOptions.data =  needsSerialization ? JSON.stringify(connectionCommandRequest || {}) : (connectionCommandRequest || "");

            return {
                url: url.format(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary CreateConnection
         * @param {ConnectionRequest} connectionRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createConnection(connectionRequest: ConnectionRequest, options: any = {}): RequestArgs {
            // verify required parameter 'connectionRequest' is not null or undefined
            if (connectionRequest === null || connectionRequest === undefined) {
                throw new RequiredError('connectionRequest','Required parameter connectionRequest was null or undefined when calling createConnection.');
            }
            const localVarPath = `/connection`;
            const localVarUrlObj = url.parse(localVarPath, true);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = Object.assign({ method: 'POST' }, baseOptions, options);
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            localVarHeaderParameter['Content-Type'] = 'application/json';

            localVarUrlObj.query = Object.assign({}, localVarUrlObj.query, localVarQueryParameter, options.query);
            // fix override query string Detail: https://stackoverflow.com/a/7517673/1077943
            delete localVarUrlObj.search;
            localVarRequestOptions.headers = Object.assign({}, localVarHeaderParameter, options.headers);
            const needsSerialization = (<any>"ConnectionRequest" !== "string") || localVarRequestOptions.headers['Content-Type'] === 'application/json';
            localVarRequestOptions.data =  needsSerialization ? JSON.stringify(connectionRequest || {}) : (connectionRequest || "");

            return {
                url: url.format(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary DestroyConnection
         * @param {DestroyConnectionRequest} destroyConnectionRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        destroyConnection(destroyConnectionRequest: DestroyConnectionRequest, options: any = {}): RequestArgs {
            // verify required parameter 'destroyConnectionRequest' is not null or undefined
            if (destroyConnectionRequest === null || destroyConnectionRequest === undefined) {
                throw new RequiredError('destroyConnectionRequest','Required parameter destroyConnectionRequest was null or undefined when calling destroyConnection.');
            }
            const localVarPath = `/connection`;
            const localVarUrlObj = url.parse(localVarPath, true);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = Object.assign({ method: 'HEAD' }, baseOptions, options);
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            localVarHeaderParameter['Content-Type'] = 'application/json';

            localVarUrlObj.query = Object.assign({}, localVarUrlObj.query, localVarQueryParameter, options.query);
            // fix override query string Detail: https://stackoverflow.com/a/7517673/1077943
            delete localVarUrlObj.search;
            localVarRequestOptions.headers = Object.assign({}, localVarHeaderParameter, options.headers);
            const needsSerialization = (<any>"DestroyConnectionRequest" !== "string") || localVarRequestOptions.headers['Content-Type'] === 'application/json';
            localVarRequestOptions.data =  needsSerialization ? JSON.stringify(destroyConnectionRequest || {}) : (destroyConnectionRequest || "");

            return {
                url: url.format(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
        /**
         * 
         * @summary GetActiveConnections
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getActiveConnections(options: any = {}): RequestArgs {
            const localVarPath = `/connection`;
            const localVarUrlObj = url.parse(localVarPath, true);
            let baseOptions;
            if (configuration) {
                baseOptions = configuration.baseOptions;
            }
            const localVarRequestOptions = Object.assign({ method: 'GET' }, baseOptions, options);
            const localVarHeaderParameter = {} as any;
            const localVarQueryParameter = {} as any;

            localVarUrlObj.query = Object.assign({}, localVarUrlObj.query, localVarQueryParameter, options.query);
            // fix override query string Detail: https://stackoverflow.com/a/7517673/1077943
            delete localVarUrlObj.search;
            localVarRequestOptions.headers = Object.assign({}, localVarHeaderParameter, options.headers);

            return {
                url: url.format(localVarUrlObj),
                options: localVarRequestOptions,
            };
        },
    }
};

/**
 * ConnectionApi - functional programming interface
 * @export
 */
export const ConnectionApiFp = function(configuration?: Configuration) {
    return {
        /**
         * 
         * @summary AddCommand
         * @param {ConnectionCommandRequest} connectionCommandRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addCommand(connectionCommandRequest: ConnectionCommandRequest, options?: any): (axios?: AxiosInstance, basePath?: string) => AxiosPromise<ConnectionCommandResponse> {
            const localVarAxiosArgs = ConnectionApiAxiosParamCreator(configuration).addCommand(connectionCommandRequest, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = Object.assign(localVarAxiosArgs.options, {url: basePath + localVarAxiosArgs.url})
                return axios.request(axiosRequestArgs);                
            };
        },
        /**
         * 
         * @summary CreateConnection
         * @param {ConnectionRequest} connectionRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createConnection(connectionRequest: ConnectionRequest, options?: any): (axios?: AxiosInstance, basePath?: string) => AxiosPromise<ConnectionStatus> {
            const localVarAxiosArgs = ConnectionApiAxiosParamCreator(configuration).createConnection(connectionRequest, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = Object.assign(localVarAxiosArgs.options, {url: basePath + localVarAxiosArgs.url})
                return axios.request(axiosRequestArgs);                
            };
        },
        /**
         * 
         * @summary DestroyConnection
         * @param {DestroyConnectionRequest} destroyConnectionRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        destroyConnection(destroyConnectionRequest: DestroyConnectionRequest, options?: any): (axios?: AxiosInstance, basePath?: string) => AxiosPromise<ConnectionStatus> {
            const localVarAxiosArgs = ConnectionApiAxiosParamCreator(configuration).destroyConnection(destroyConnectionRequest, options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = Object.assign(localVarAxiosArgs.options, {url: basePath + localVarAxiosArgs.url})
                return axios.request(axiosRequestArgs);                
            };
        },
        /**
         * 
         * @summary GetActiveConnections
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getActiveConnections(options?: any): (axios?: AxiosInstance, basePath?: string) => AxiosPromise<Array<Connection>> {
            const localVarAxiosArgs = ConnectionApiAxiosParamCreator(configuration).getActiveConnections(options);
            return (axios: AxiosInstance = globalAxios, basePath: string = BASE_PATH) => {
                const axiosRequestArgs = Object.assign(localVarAxiosArgs.options, {url: basePath + localVarAxiosArgs.url})
                return axios.request(axiosRequestArgs);                
            };
        },
    }
};

/**
 * ConnectionApi - factory interface
 * @export
 */
export const ConnectionApiFactory = function (configuration?: Configuration, basePath?: string, axios?: AxiosInstance) {
    return {
        /**
         * 
         * @summary AddCommand
         * @param {ConnectionCommandRequest} connectionCommandRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        addCommand(connectionCommandRequest: ConnectionCommandRequest, options?: any) {
            return ConnectionApiFp(configuration).addCommand(connectionCommandRequest, options)(axios, basePath);
        },
        /**
         * 
         * @summary CreateConnection
         * @param {ConnectionRequest} connectionRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        createConnection(connectionRequest: ConnectionRequest, options?: any) {
            return ConnectionApiFp(configuration).createConnection(connectionRequest, options)(axios, basePath);
        },
        /**
         * 
         * @summary DestroyConnection
         * @param {DestroyConnectionRequest} destroyConnectionRequest 
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        destroyConnection(destroyConnectionRequest: DestroyConnectionRequest, options?: any) {
            return ConnectionApiFp(configuration).destroyConnection(destroyConnectionRequest, options)(axios, basePath);
        },
        /**
         * 
         * @summary GetActiveConnections
         * @param {*} [options] Override http request option.
         * @throws {RequiredError}
         */
        getActiveConnections(options?: any) {
            return ConnectionApiFp(configuration).getActiveConnections(options)(axios, basePath);
        },
    };
};

/**
 * ConnectionApi - object-oriented interface
 * @export
 * @class ConnectionApi
 * @extends {BaseAPI}
 */
export class ConnectionApi extends BaseAPI {
    /**
     * 
     * @summary AddCommand
     * @param {ConnectionCommandRequest} connectionCommandRequest 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof ConnectionApi
     */
    public addCommand(connectionCommandRequest: ConnectionCommandRequest, options?: any) {
        return ConnectionApiFp(this.configuration).addCommand(connectionCommandRequest, options)(this.axios, this.basePath);
    }

    /**
     * 
     * @summary CreateConnection
     * @param {ConnectionRequest} connectionRequest 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof ConnectionApi
     */
    public createConnection(connectionRequest: ConnectionRequest, options?: any) {
        return ConnectionApiFp(this.configuration).createConnection(connectionRequest, options)(this.axios, this.basePath);
    }

    /**
     * 
     * @summary DestroyConnection
     * @param {DestroyConnectionRequest} destroyConnectionRequest 
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof ConnectionApi
     */
    public destroyConnection(destroyConnectionRequest: DestroyConnectionRequest, options?: any) {
        return ConnectionApiFp(this.configuration).destroyConnection(destroyConnectionRequest, options)(this.axios, this.basePath);
    }

    /**
     * 
     * @summary GetActiveConnections
     * @param {*} [options] Override http request option.
     * @throws {RequiredError}
     * @memberof ConnectionApi
     */
    public getActiveConnections(options?: any) {
        return ConnectionApiFp(this.configuration).getActiveConnections(options)(this.axios, this.basePath);
    }

}
