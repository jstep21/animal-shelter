import { createRouter as createRouter, createWebHistory } from 'vue-router'
import { useStore } from 'vuex'

// Import components
import HomeView from '../views/HomeView.vue';
import LoginView from '../views/LoginView.vue';
import LogoutView from '../views/LogoutView.vue';
import RegisterView from '../views/RegisterView.vue';
import BrowsePetsView from '../views/BrowsePetsView.vue';
import PetDetailsView from '../views/PetDetailsView.vue';
import ApplyView from '../views/ApplyView.vue';
import AddPetView from '../views/AddPetView.vue';
import ApproveView from '../views/ApproveView.vue';
import VolunteerListView from '../views/VolunteerListView.vue';
import UpdatePasswordView from '../views/UpdatePasswordView.vue';
import PrivacyPolicyView from '../views/PrivacyPolicyView.vue'
import UpdatePetView from '../views/UpdatePetView.vue'

// for testing:
import Carousel from '../components/Carousel.vue'; //
// import PetTableTest from '../components/PetTableTest.vue'; //
// import PetDetails from '../components/PetDetails.vue'; //

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */
const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/login",
    name: "login",
    component: LoginView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/logout",
    name: "logout",
    component: LogoutView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/register",
    name: "register",
    component: RegisterView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/browse-pets",
    name: "browse-pets",
    component: BrowsePetsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/pets/:petId",
    name: "pet-details",
    component: PetDetailsView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/apply",
    name: "apply",
    component: ApplyView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/add-pet",
    name: "add-pet",
    component: AddPetView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/approve",
    name: "approve",
    component: ApproveView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/test",
    name: "test",
    component: Carousel,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/volunteer-list",
    name: "volunteer-list",
    component: VolunteerListView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/update-password",
    name: "update-password",
    component: UpdatePasswordView,
    meta: {
      requiresAuth: true
    }
  },
  {
    path: "/privacy-policy",
    name: "privacy-policy",
    component: PrivacyPolicyView,
    meta: {
      requiresAuth: false
    }
  },
  {
    path: "/update-pet",
    name: "update-pet",
    component: UpdatePetView,
    meta: {
      requiresAuth: true
    }
  },
];

// Create the router
const router = createRouter({
  history: createWebHistory(),
  routes: routes
});

router.beforeEach((to) => {

  // Get the Vuex store
  const store = useStore();

  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    return {name: "login"};
  }
  // Otherwise, do nothing and they'll go to their next destination
});

export default router;
