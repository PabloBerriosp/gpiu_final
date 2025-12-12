import axios from 'axios'

const API_BASE_URL = 'http://localhost:8080/api/contenidos'

export interface ContenidoDTO {
    idContenido?: number
    titulo: string
    cuerpo: string
    categoria: string
    ambito: string
    visibilidad: string
    vigenciaInicio: string
    vigenciaFin: string
    estado: string
}

export async function crearContenido(nuevo: ContenidoDTO): Promise<ContenidoDTO> {
    const response = await axios.post(API_BASE_URL, nuevo)
    return response.data
}

export async function listarContenidos(): Promise<ContenidoDTO[]> {
    const response = await axios.get(API_BASE_URL)
    return response.data
}

