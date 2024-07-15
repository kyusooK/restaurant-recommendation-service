<template>
    <v-card outlined>
        <v-card-title>
            SearchRestaurant
        </v-card-title>

        <v-card-text>
            <String label="Keyword" v-model="value.keyword" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="searchRestaurant"
            >
                SearchRestaurant
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
        name: 'SearchRestaurantCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.keyword = '';
        },
        watch: {
        },
        methods: {
            searchRestaurant() {
                this.$emit('searchRestaurant', this.value);
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

