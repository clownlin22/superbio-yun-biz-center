(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[14],{H2Vp:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var r=n(a("SeLb")),u=n(a("fh3l")),s=a("+xKz"),c={namespace:"departMent",state:{data:[],dataList:[],Result:[],Experimental:[],ConfState:[]},effects:{fetch:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.queryDeparts,n);case 4:return l=e.sent,e.next=7,c({type:"save",payload:l});case 7:case"end":return e.stop()}},e,this)}),fetchExperimental:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.queryExperimentals,n);case 4:return l=e.sent,e.next=7,c({type:"saveExperimental",payload:l});case 7:case"end":return e.stop()}},e,this)}),fetchConfState:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.queryConfStates,n);case 4:return l=e.sent,e.next=7,c({type:"saveConfState",payload:l});case 7:case"end":return e.stop()}},e,this)}),add:u.default.mark(function e(t,a){var n,r,c;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,e.next=4,r(s.addDepart,n);case 4:c=e.sent,n.resolve(c);case 6:case"end":return e.stop()}},e,this)}),remove:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.removeDepart,n);case 4:return l=e.sent,n.resolve(l),e.next=8,c({type:"ForceDelete",payload:n});case 8:case"end":return e.stop()}},e,this)}),update:u.default.mark(function e(t,a){var n,r,c;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,a.put,e.next=4,r(s.updateDepart,n);case 4:c=e.sent,n.resolve(c);case 6:case"end":return e.stop()}},e,this)}),getDistrict:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.getDistrict,n);case 4:return l=e.sent,e.next=7,c({type:"save",payload:l});case 7:case"end":return e.stop()}},e,this)}),fetchDistrict:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.queryDepartList,n);case 4:return l=e.sent,e.next=7,c({type:"saveList",payload:l});case 7:case"end":return e.stop()}},e,this)})},reducers:{save:function(e,t){var a={list:t.payload,total:t.payload.length};return(0,r.default)({},e,{data:a})},saveResult:function(e,t){return(0,r.default)({},e,{Result:t.payload})},saveExperimental:function(e,t){return(0,r.default)({},e,{Experimental:t.payload})},saveConfState:function(e,t){return(0,r.default)({},e,{ConfState:t.payload})},saveList:function(e,t){return(0,r.default)({},e,{dataList:t.payload})},ForceDelete:function(e,t){var a=e.data,n=a.list,u=function(e){n.splice(n.findIndex(function(a){return a.id===t.payload[e].toString()}),1);var a=n.filter(function(a){return a.parentIds.match(new RegExp(t.payload[e].toString()))}),r=function(e){n.splice(n.findIndex(function(t){return t.id===a[e].id}),1)};for(var u in a)r(u)};for(var s in t.payload)u(s);return(0,r.default)({},e,{data:a})}}};t.default=c}}]);