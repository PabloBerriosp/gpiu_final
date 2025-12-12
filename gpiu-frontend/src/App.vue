<template>
  <div class="app">
    <header class="topbar">
      <h1 class="title">GPIU</h1>

      <nav class="menu">
        <RouterLink class="item" to="/crear-contenido">Crear Contenido</RouterLink>
        <RouterLink class="item" to="/consultar-horario">Consultar Horario</RouterLink>
      </nav>
    </header>

    <main class="content">
      <RouterView />
    </main>
  </div>
</template>

<script setup lang="ts">
import { RouterLink, RouterView } from "vue-router";
</script>

<style scoped>
.app {
  font-family: Arial, sans-serif;
}

.topbar {
  background: #1f2937;      /* gris oscuro */
  padding: 12px 16px;
  display: flex;
  align-items: center;
  gap: 16px;
}

.title {
  color: white;
  font-size: 18px;
  margin: 0;
  width: 90px;
}

.menu {
  display: flex;
  gap: 10px;
}

.item {
  color: white;
  text-decoration: none;
  padding: 8px 12px;
  border-radius: 8px;
  background: #374151;      /* gris medio */
}

.item:hover {
  background: #4b5563;
}

/* Vue Router agrega esta clase automáticamente al link activo */
.item.router-link-active {
  background: #2563eb;      /* azul */
}

.content {
  padding: 16px;
}
</style>

