
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ImprovedRestaurantSearchRestaurantManager from "./components/listers/ImprovedRestaurantSearchRestaurantCards"
import ImprovedRestaurantSearchRestaurantDetail from "./components/listers/ImprovedRestaurantSearchRestaurantDetail"

import SimplifiedOrderProcessOrderManager from "./components/listers/SimplifiedOrderProcessOrderCards"
import SimplifiedOrderProcessOrderDetail from "./components/listers/SimplifiedOrderProcessOrderDetail"

import EnhancedAddressInputDeliveryAddressManager from "./components/listers/EnhancedAddressInputDeliveryAddressCards"
import EnhancedAddressInputDeliveryAddressDetail from "./components/listers/EnhancedAddressInputDeliveryAddressDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/improvedRestaurantSearches/restaurants',
                name: 'ImprovedRestaurantSearchRestaurantManager',
                component: ImprovedRestaurantSearchRestaurantManager
            },
            {
                path: '/improvedRestaurantSearches/restaurants/:id',
                name: 'ImprovedRestaurantSearchRestaurantDetail',
                component: ImprovedRestaurantSearchRestaurantDetail
            },

            {
                path: '/simplifiedOrderProcesses/orders',
                name: 'SimplifiedOrderProcessOrderManager',
                component: SimplifiedOrderProcessOrderManager
            },
            {
                path: '/simplifiedOrderProcesses/orders/:id',
                name: 'SimplifiedOrderProcessOrderDetail',
                component: SimplifiedOrderProcessOrderDetail
            },

            {
                path: '/enhancedAddressInputs/deliveryAddresses',
                name: 'EnhancedAddressInputDeliveryAddressManager',
                component: EnhancedAddressInputDeliveryAddressManager
            },
            {
                path: '/enhancedAddressInputs/deliveryAddresses/:id',
                name: 'EnhancedAddressInputDeliveryAddressDetail',
                component: EnhancedAddressInputDeliveryAddressDetail
            },



    ]
})
