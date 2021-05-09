import { get, post } from './request'

export const getMessage = p => get('/client/getMessage', p);

export const addMessage = p => post('/client/addMessage', p);

export const addLikeNum = p => get('/client/addLikeNum', p);

export const getLikeNum = p => get('/client/getLikeNum', p);