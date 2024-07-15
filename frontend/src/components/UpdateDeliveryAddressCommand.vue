<template>
    <v-card outlined>
        <v-card-title>
            UpdateDeliveryAddress
        </v-card-title>

        <v-card-text>
            <Address offline label="Address" v-model="value.address" :editMode="editMode" @change="change"/>
            <Date label="DeliveryTime" v-model="value.deliveryTime" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="updateDeliveryAddress"
            >
                UpdateDeliveryAddress
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'UpdateDeliveryAddressCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.address = {};
            this.value.deliveryTime = {};
        },
        watch: {
        },
        methods: {
            updateDeliveryAddress() {
                this.$emit('updateDeliveryAddress', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

