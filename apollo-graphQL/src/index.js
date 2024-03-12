import {ApolloServer} from 'apollo-server';
import resolvers from './graphql/resolvers.js';
import typeDefs from './graphql/typeDefs.js';
import orderRestApi from './restApiServer/order-rest-api.js'
import inventoryRestApi from './restApiServer/inventory-rest-api.js'
import deliveryRestApi from './restApiServer/delivery-rest-api.js'
import customerCenterRestApi from './restApiServer/customerCenter-rest-api.js'

const server = new ApolloServer({
    typeDefs,
    resolvers,
    dataSources: () => ({
        orderRestApi: new orderRestApi(),
        inventoryRestApi: new inventoryRestApi(),
        deliveryRestApi: new deliveryRestApi(),
        customerCenterRestApi: new customerCenterRestApi(),
    }),
});

server.listen({
    port: 8089,
}).then(({url}) => {
    console.log(`🚀  Server ready at ${url}`);
});
