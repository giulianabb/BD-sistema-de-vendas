$(document).ready(function() {
	
	$.fn.dataTable.ext.type.order['semana-pre'] = function ( d ) {
	    switch ( d ) {
	        case 'Segunda-feira':   	return 1;
	        case 'Terça-feira': 		return 2;
	        case 'Quarta-feira':		return 3;
	        case 'Quinta-feira':		return 4;
	        case 'Sexta-feira':			return 5;
	        case 'Sábado':				return 6;
	        case 'Domingo':				return 7;
	        default:					return 8;
	    }
	    return 0;
	};
	
	
	
	$('#table_todos').DataTable({
        "language": {
        	"url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        "columnDefs": [ {
            "type": "semana",
            "targets": 2
        } ]
    } );
	
	
	$('#table_simples').DataTable({
        "language": {
        	"url": "//cdn.datatables.net/plug-ins/1.10.13/i18n/Portuguese-Brasil.json"
        },
        searching: false,
        paging: false
    } );
});