require: slotfilling/slotFilling.sc
  module = sys.zb-common
  
# Подключение javascript обработчиков
require: scripts/getters.js
require: scripts/reply.js
require: scripts/actions.js
require: scripts/findItem.js

# Подключение сценарных файлов
require: sceenaries/addNote.sc
require: sceenaries/doNote.sc
require: sceenaries/deleteNote.sc


patterns:
    $AnyText = $nonEmptyGarbage

theme: /
    state: Start
        # При запуске приложения с кнопки прилетит сообщение /start.
        q!: $regex</start>
        # При запуске приложения с голоса прилетит сказанная фраза.
        q!: (запусти | открой | вруби) Салют Демо Апп
        a: Начнём.
        
        
    state: Привет
        q!: привет
        a: Привет привет
    
    state: Пока
        q!: /пока
        a: Пока покa
        

    state: Fallback
        event!: noMatch
        a: Я не понимаю. Вы сказали: {{$request.query}}