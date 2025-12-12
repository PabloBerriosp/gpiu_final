import { createRouter, createWebHistory } from 'vue-router'
import CrearContenidoView from '../views/CrearContenidoView.vue'
import VistaConsultarHorario from "../views/VistaConsultarHorario.vue";

const routes = [
  {
    path: '/crear-contenido',
    name: 'CrearContenido',
    component: CrearContenidoView
  },
  { path: "/horario", name: "Horario", component: VistaConsultarHorario },
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router

