(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([[55],{"/9CO":function(t,e,a){"use strict";var n=a("xK3H");Object.defineProperty(e,"__esModule",{value:!0}),e.page=i,e.removeByIds=d,e.download=o,e.see=h,e.enabled=m,e.add=y,e.update=x;var r=n(a("fh3l")),u=n(a("Lnrk")),s=a("Dk/q"),c=n(a("t3Un"));function i(t){return p.apply(this,arguments)}function p(){return p=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment/page?".concat((0,s.stringify)(e))));case 1:case"end":return t.stop()}},t,this)})),p.apply(this,arguments)}function d(t){return l.apply(this,arguments)}function l(){return l=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment?ids=".concat(e),{method:"DELETE"}));case 1:case"end":return t.stop()}},t,this)})),l.apply(this,arguments)}function o(t){return f.apply(this,arguments)}function f(){return f=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment/{id}/download?".concat((0,s.stringify)(e)),{method:"GET"}));case 1:case"end":return t.stop()}},t,this)})),f.apply(this,arguments)}function h(t){return w.apply(this,arguments)}function w(){return w=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment/see?".concat((0,s.stringify)(e)),{method:"GET"}));case 1:case"end":return t.stop()}},t,this)})),w.apply(this,arguments)}function m(t){return b.apply(this,arguments)}function b(){return b=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment/{id}?".concat((0,s.stringify)(e)),{method:"PUT"}));case 1:case"end":return t.stop()}},t,this)})),b.apply(this,arguments)}function y(t){return v.apply(this,arguments)}function v(){return v=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment",{method:"POST",body:e.formData}));case 1:case"end":return t.stop()}},t,this)})),v.apply(this,arguments)}function x(t){return k.apply(this,arguments)}function k(){return k=(0,u.default)(r.default.mark(function t(e){return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return t.abrupt("return",(0,c.default)("/spbbase-attachment-web/api/attachment",{method:"PUT",body:e}));case 1:case"end":return t.stop()}},t,this)})),k.apply(this,arguments)}},Tc7Z:function(t,e,a){"use strict";var n=a("xK3H");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0;var r=n(a("fh3l")),u=n(a("SeLb")),s=a("/9CO"),c={namespace:"AttachmentModal",state:{data:{},bizType:[{title:"\u4eb2\u5b50\u9274\u5b9a",dataIndex:"\u4eb2\u5b50\u9274\u5b9a"},{title:"\u6587\u4e66\u9274\u5b9a",dataIndex:"\u6587\u4e66\u9274\u5b9a"},{title:"\u9152\u7cbe\u9274\u5b9a",dataIndex:"\u9152\u7cbe\u9274\u5b9a"},{title:"\u8f66\u8f86\u75d5\u8ff9\u9274\u5b9a",dataIndex:"\u8f66\u8f86\u75d5\u8ff9\u9274\u5b9a"},{title:"\u6cd5\u533b\u4e34\u5e8a\u9274\u5b9a",dataIndex:"\u6cd5\u533b\u4e34\u5e8a\u9274\u5b9a"}]},effects:{page:r.default.mark(function t(e,a){var n,c,i,p;return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,c=a.call,i=a.put,t.next=4,c(s.page,n);case 4:return p=t.sent,t.next=7,i({type:"save",payload:(0,u.default)({},p,{pageSize:n.pageSize,current:n.currentPage})});case 7:case"end":return t.stop()}},t,this)}),add:r.default.mark(function t(e,a){var n,u,c;return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,u=a.call,a.put,t.next=4,u(s.add,n);case 4:c=t.sent,n.resolve(c);case 6:case"end":return t.stop()}},t,this)}),removeByIds:r.default.mark(function t(e,a){var n,u,c;return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,u=a.call,a.put,t.next=4,u(s.removeByIds,n.ids);case 4:c=t.sent,n.resolve(c);case 6:case"end":return t.stop()}},t,this)}),enabled:r.default.mark(function t(e,a){var n,u;return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,u=a.call,a.put,console.log(n.AttachmentList),t.next=5,u(s.enabled,n.AttachmentList);case 5:t.sent;case 6:case"end":return t.stop()}},t,this)}),update:r.default.mark(function t(e,a){var n,u,c;return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,u=a.call,a.put,console.log("payload.AttachmentList",n.AttachmentList),t.next=5,u(s.update,n.AttachmentList);case 5:c=t.sent,n.resolve(c);case 7:case"end":return t.stop()}},t,this)}),download:r.default.mark(function t(e,a){var n,u,c;return r.default.wrap(function(t){while(1)switch(t.prev=t.next){case 0:return n=e.payload,u=a.call,a.put,t.next=4,u(s.download,n);case 4:c=t.sent,n.resolve(c);case 6:case"end":return t.stop()}},t,this)})},reducers:{save:function(t,e){return(0,u.default)({},t,{data:{list:e.payload.items,pagination:{total:e.payload.count,pageSize:e.payload.pageSize,current:e.payload.current}}})}}};e.default=c}}]);