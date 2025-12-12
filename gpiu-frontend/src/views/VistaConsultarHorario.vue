<script setup lang="ts">
import { onMounted, ref } from "vue";
import { obtenerHorarioActual, type Horario } from "../api/HorarioApi";

const idEstudiante = ref<number>(1); // Usa el id que imprimió el backend en consola
const horario = ref<Horario | null>(null);
const errorMsg = ref<string>("");

async function cargarHorario() {
  errorMsg.value = "";
  horario.value = null;

  try {
    horario.value = await obtenerHorarioActual(idEstudiante.value);
  } catch (err: any) {
    errorMsg.value =
        err?.response?.data?.message ??
        err?.message ??
        "Error consultando horario";
  }
}

onMounted(() => {
  cargarHorario();
});
</script>

<template>
  <div style="max-width: 900px; margin: 0 auto; padding: 16px;">
    <h2>Consultar Horario</h2>

    <div style="display: flex; gap: 8px; align-items: center; margin-bottom: 12px;">
      <label>Id Estudiante:</label>
      <input v-model.number="idEstudiante" type="number" min="1" />
      <button @click="cargarHorario">Consultar</button>
    </div>

    <p v-if="errorMsg" style="color: red;">{{ errorMsg }}</p>

    <div v-if="horario">
      <p><strong>ID Horario:</strong> {{ horario.idHorario }}</p>
      <p><strong>Última actualización:</strong> {{ horario.ultimaActualizacion }}</p>

      <table border="1" cellpadding="8" cellspacing="0" style="width: 100%; margin-top: 12px;">
        <thead>
        <tr>
          <th>Día</th>
          <th>Hora Inicio</th>
          <th>Hora Fin</th>
          <th>Sala</th>
          <th>Código</th>
          <th>Asignatura</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="b in horario.bloques" :key="b.idBloque">
          <td>{{ b.dia }}</td>
          <td>{{ b.horaInicio.substring(0,5) }}</td>
          <td>{{ b.horaFin.substring(0,5) }}</td>
          <td>{{ b.sala }}</td>
          <td>{{ b.asignatura.codigo }}</td>
          <td>{{ b.asignatura.nombre }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>
