(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[25],{ak1a:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.queryReportRevData=i,t.updateStatusValue=o,t.queryChooses=f,t.queryCaseState=y;var r=n(a("SeLb")),u=n(a("fh3l")),s=n(a("Lnrk")),c=a("Dk/q"),l=n(a("t3Un"));function i(e){return p.apply(this,arguments)}function p(){return p=(0,s.default)(u.default.mark(function e(t){return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,l.default)("/biz-cases-web/api/case/list?".concat((0,c.stringify)(t))));case 1:case"end":return e.stop()}},e,this)})),p.apply(this,arguments)}function o(e){return d.apply(this,arguments)}function d(){return d=(0,s.default)(u.default.mark(function e(t){return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,l.default)("/api/authcenter/dictValue",{method:"POST",body:(0,r.default)({},t,{method:"updateStatusValue"})}));case 1:case"end":return e.stop()}},e,this)})),d.apply(this,arguments)}function f(){return h.apply(this,arguments)}function h(){return h=(0,s.default)(u.default.mark(function e(){return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,l.default)("/dictapi/setChooses"));case 1:case"end":return e.stop()}},e,this)})),h.apply(this,arguments)}function y(){return w.apply(this,arguments)}function w(){return w=(0,s.default)(u.default.mark(function e(){return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return e.abrupt("return",(0,l.default)("/caseapi/getCaseStates"));case 1:case"end":return e.stop()}},e,this)})),w.apply(this,arguments)}},iOHO:function(e,t,a){"use strict";var n=a("xK3H");Object.defineProperty(t,"__esModule",{value:!0}),t.default=void 0;var r=n(a("SeLb")),u=n(a("fh3l")),s=a("ak1a"),c={namespace:"reportRevData",state:{data:{list:[],pagination:{}},Choose:[],caseState:[]},effects:{fetch:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.queryReportRevData,n);case 4:return l=e.sent,e.next=7,c({type:"save",payload:l});case 7:case"end":return e.stop()}},e,this)}),updateStatusValue:u.default.mark(function e(t,a){var n,r,c,l,i;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=t.callback,c=a.call,l=a.put,e.next=4,c(s.updateStatusValue,n);case 4:return i=e.sent,e.next=7,l({type:"save",payload:i});case 7:r&&r();case 8:case"end":return e.stop()}},e,this)}),fetchChooses:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,r=a.call,c=a.put,e.next=4,r(s.queryChooses,n);case 4:return l=e.sent,e.next=7,c({type:"Choose",payload:l});case 7:case"end":return e.stop()}},e,this)}),caseStates:u.default.mark(function e(t,a){var n,r,c,l;return u.default.wrap(function(e){while(1)switch(e.prev=e.next){case 0:return n=t.payload,t.callback,r=a.call,c=a.put,e.next=4,r(s.queryCaseState,n);case 4:return l=e.sent,e.next=7,c({type:"caseState",payload:l});case 7:case"end":return e.stop()}},e,this)})},reducers:{save:function(e,t){var a={list:t.payload,total:t.length};return(0,r.default)({},e,{data:a})},Choose:function(e,t){return(0,r.default)({},e,{Choose:t.payload})},caseState:function(e,t){return(0,r.default)({},e,{caseState:t.payload})}}};t.default=c}}]);