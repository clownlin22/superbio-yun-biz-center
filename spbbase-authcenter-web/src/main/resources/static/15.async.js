(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[15],{SrfR:function(e,t,a){"use strict";var r=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var n=r(a("SeLb")),s=r(a("fh3l")),u=a("+xKz"),l={namespace:"manageUser",state:{data:{list:[],pagination:{}},department:[],role:[],fileStatuss:[{id:0,experState:"\u5426"},{id:1,experState:"\u662f"}],experResult:[],confState:[],Reagent:[],userRole:[],userDept:[]},effects:{fetch:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryUser,r);case 4:return c=e.sent,e.next=7,l({type:"save",payload:c});case 7:case"end":return e.stop()}},e,this)}),add:s.default.mark(function e(t,a){var r,n,l;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,t.callback,n=a.call,e.next=4,n(u.addUser,r);case 4:l=e.sent,r.resolve(l);case 6:case"end":return e.stop()}},e,this)}),remove:s.default.mark(function e(t,a){var r,n,l;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,e.next=4,n(u.removeUser,r);case 4:l=e.sent,r.resolve(l);case 6:case"end":return e.stop()}},e,this)}),fetchDepart:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryDepart,r);case 4:return c=e.sent,e.next=7,l({type:"saveDepart",payload:c});case 7:case"end":return e.stop()}},e,this)}),fetchRoles:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryRole,r);case 4:return c=e.sent,e.next=7,l({type:"saveRole",payload:c});case 7:case"end":return e.stop()}},e,this)}),update:s.default.mark(function e(t,a){var r,n,l;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,e.next=4,n(u.updateUser,r);case 4:l=e.sent,r.resolve(l);case 6:case"end":return e.stop()}},e,this)}),insertRole:s.default.mark(function e(t,a){var r,n;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,e.next=4,n(u.insertRoles,r);case 4:case"end":return e.stop()}},e,this)}),updateStatus:s.default.mark(function e(t,a){var r,n,l;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,e.next=4,n(u.updateStatusUser,r);case 4:l=e.sent,r.resolve(l);case 6:case"end":return e.stop()}},e,this)}),updatePass:s.default.mark(function e(t,a){var r,n,l;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,e.next=4,n(u.updateUserPass,r);case 4:l=e.sent,r.resolve(l);case 6:case"end":return e.stop()}},e,this)}),fetchUserDept:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryUserDept,r);case 4:return c=e.sent,e.next=7,l({type:"saveUserDept",payload:c});case 7:case"end":return e.stop()}},e,this)}),fetchUserRole:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryUserRole,r);case 4:return c=e.sent,e.next=7,l({type:"saveUserRole",payload:c});case 7:case"end":return e.stop()}},e,this)}),fetchConfState:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryConfState,r);case 4:return c=e.sent,e.next=7,l({type:"saveConfState",payload:c});case 7:case"end":return e.stop()}},e,this)}),fetchReagent:s.default.mark(function e(t,a){var r,n,l,c;return s.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return r=t.payload,n=a.call,l=a.put,e.next=4,n(u.queryDepartList,r);case 4:return c=e.sent,e.next=7,l({type:"saveReagent",payload:c});case 7:case"end":return e.stop()}},e,this)})},reducers:{save:function(e,t){var a={list:t.payload,total:t.payload.length};return(0,n.default)({},e,{data:a})},saveDepart:function(e,t){return(0,n.default)({},e,{department:t.payload})},saveRole:function(e,t){return(0,n.default)({},e,{role:t.payload})},saveUserDept:function(e,t){return(0,n.default)({},e,{userDept:t.payload})},saveUserRole:function(e,t){return(0,n.default)({},e,{userRole:t.payload})},saveResult:function(e,t){return(0,n.default)({},e,{experResult:t.payload})},saveConfState:function(e,t){return(0,n.default)({},e,{confState:t.payload})},saveReagent:function(e,t){return(0,n.default)({},e,{Reagent:t.payload})}}};t.default=l}}]);