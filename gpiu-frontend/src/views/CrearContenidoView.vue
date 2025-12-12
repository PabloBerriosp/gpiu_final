<template>
  <div class="container">
    <h1>Crear Contenido</h1>

    <form @submit.prevent="onSubmit" class="form">
      <div class="field">
        <label for="titulo">Título</label>
        <input id="titulo" v-model="form.titulo" required />
      </div>

      <div class="field">
        <label for="cuerpo">Cuerpo</label>
        <textarea id="cuerpo" v-model="form.cuerpo" rows="4" required></textarea>
      </div>

      <div class="field">
        <label for="categoria">Categoría</label>
        <input id="categoria" v-model="form.categoria" required />
      </div>

      <div class="field">
        <label for="ambito">Ámbito</label>
        <select id="ambito" v-model="form.ambito" required>
          <option value="">Seleccione...</option>
          <option value="ACADEMICO">Académico</option>
          <option value="ADMINISTRATIVO">Administrativo</option>
          <option value="GENERAL">General</option>
        </select>
      </div>

      <div class="field">
        <label for="visibilidad">Visibilidad</label>
        <select id="visibilidad" v-model="form.visibilidad" required>
          <option value="">Seleccione...</option>
          <option value="ESTUDIANTE">Estudiantes</option>
          <option value="PROFESOR">Profesores</option>
          <option value="FUNCIONARIO">Funcionarios</option>
          <option value="TODOS">Todos</option>
        </select>
      </div>

      <div class="field">
        <label>Vigencia</label>
        <div class="vigencia">
          <div>
            <span>Inicio</span>
            <input type="date" v-model="form.vigenciaInicio" required />
          </div>
          <div>
            <span>Fin</span>
            <input type="date" v-model="form.vigenciaFin" required />
          </div>
        </div>
      </div>

      <div class="field">
        <label for="estado">Estado</label>
        <select id="estado" v-model="form.estado" required>
          <option value="BORRADOR">Borrador</option>
          <option value="PUBLICADO">Publicado</option>
        </select>
      </div>

      <button type="submit" :disabled="cargando">
        {{ cargando ? 'Guardando...' : 'Guardar contenido' }}
      </button>

      <p v-if="mensaje" class="mensaje-ok">{{ mensaje }}</p>
      <p v-if="error" class="mensaje-error">{{ error }}</p>
    </form>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { crearContenido, type ContenidoDTO } from '../services/ContenidoService'

const form = ref<ContenidoDTO>({
  titulo: '',
  cuerpo: '',
  categoria: '',
  ambito: '',
  visibilidad: '',
  vigenciaInicio: '',
  vigenciaFin: '',
  estado: 'BORRADOR'
})

const cargando = ref(false)
const mensaje = ref('')
const error = ref('')

async function onSubmit() {
  cargando.value = true
  mensaje.value = ''
  error.value = ''

  try {
    await crearContenido(form.value)
    mensaje.value = 'Contenido creado correctamente.'
    // limpiar formulario
    form.value = {
      titulo: '',
      cuerpo: '',
      categoria: '',
      ambito: '',
      visibilidad: '',
      vigenciaInicio: '',
      vigenciaFin: '',
      estado: 'BORRADOR'
    }
  } catch (e: any) {
    console.error(e)
    error.value = 'Ocurrió un error al crear el contenido.'
  } finally {
    cargando.value = false
  }
}
</script>

<style scoped>
.container {
  max-width: 600px;
  margin: 2rem auto;
  padding: 1.5rem;
  border: 1px solid #ddd;
  border-radius: 8px;
}
.field {
  margin-bottom: 1rem;
  display: flex;
  flex-direction: column;
}
label {
  font-weight: 600;
  margin-bottom: 0.25rem;
}
input,
textarea,
select {
  padding: 0.5rem;
  font-size: 0.95rem;
}
button {
  padding: 0.6rem 1.2rem;
  font-size: 1rem;
  cursor: pointer;
}
.vigencia {
  display: flex;
  gap: 1rem;
}
.mensaje-ok {
  margin-top: 1rem;
  color: green;
}
.mensaje-error {
  margin-top: 1rem;
  color: red;
}
</style>
