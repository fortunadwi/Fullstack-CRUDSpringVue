
import Home from './pages/Home.vue';
import Add from './pages/Add.vue';
import UpdateID from './pages/UpdateForm.vue';

export default [
    {
        path: "/",
        component: Home,
    },

    {
        path: "/Add",
        component: Add,
    },

    {
        path: "/UpdateID/:id",
        component: UpdateID,
        name: 'UpdateData',
    },

]