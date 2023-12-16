/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const API = 'https://apiperu.dev/api';
const TOKEN = '68ac99381cfba07e8ce7230e5ca1c98d0f770b69b2eec30e91ecb3cf65fb781a';
let lastRuc = '';
//const currentYear = new Date().getFullYear();

$('#txtRuc').on('keyup', function () {
    let ruc = $(this).val();
    if (ruc.length == 11 && lastRuc !== ruc) {
        lastRuc = ruc;
        getDataFromSunat(lastRuc).then(response => {
            $('#txtRazonSocial').val(response.data.nombre_o_razon_social);
            $('#txtEstado').val(response.data.estado);
            $('#txtCondicion').val(response.data.condicion);
            $('#txtDireccion').val(response.data.direccion);
        });
    }
});

function getDataFromReniec(dni) {
    const options = {
        url: `${API}/dni/${dni}`,
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        headers: {'Authorization': `Bearer ${TOKEN}`},
    };
    return $.ajax(options);
}

function getDataFromSunat(ruc) {
    const options = {
        url: `${API}/ruc/${ruc}`,
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        headers: {'Authorization': `Bearer ${TOKEN}`},
    };
    return $.ajax(options);
}

