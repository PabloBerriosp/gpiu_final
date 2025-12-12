import axios from "axios";

export const api = axios.create({
    baseURL: "http://localhost:8080",
});

export interface Asignatura {
    codigo: string;
    nombre: string;
}

export interface BloqueHorario {
    idBloque: number;
    dia: string;
    horaInicio: string; // viene como "08:00:00"
    horaFin: string;    // viene como "09:30:00"
    sala: string;
    asignatura: Asignatura;
}

export interface Horario {
    idHorario: number;
    ultimaActualizacion: string; // ISO
    bloques: BloqueHorario[];
}

export async function obtenerHorarioActual(idEstudiante: number): Promise<Horario> {
    const res = await api.get<Horario>(`/api/horarios/estudiante/${idEstudiante}`);
    return res.data;
}
