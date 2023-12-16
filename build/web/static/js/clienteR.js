/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const API = 'https://apiperu.dev/api';
const TOKEN = '68ac99381cfba07e8ce7230e5ca1c98d0f770b69b2eec30e91ecb3cf65fb781a';
let lastDni = '';
const currentYear = new Date().getFullYear();

$('#txtDni').on('keyup', function () {
    let dni = $(this).val();
    if (dni.length == 8 && lastDni !== dni) {
        lastDni = dni;
        getDataFromReniec(lastDni).then(response => {
            $('#txtNombres').val(response.data.nombres);
            $('#txtApellidoPaterno').val(response.data.apellido_paterno);
            $('#txtApellidoMaterno').val(response.data.apellido_materno);
            $('#txtFechaNacimiento').val(response.data.fecha_nacimiento);
            $('#txtEdad').val(currentYear - new Date(response.data.fecha_nacimiento).getFullYear());
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
        headers: {'Authorization': TOKEN},
    };
    return $.ajax(options);
}

