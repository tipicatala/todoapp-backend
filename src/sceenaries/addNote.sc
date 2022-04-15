theme: /

    state: ДобавлениеЭлемента
        q!: (~добавить|~установить|запиши|поставь|закинь|~напомнить) 
            [~напоминание|~заметка|~задание|~задача|~запись]
            $AnyText::anyText
            
        a: {{ $parseTree._anyText }}
        random:
            a: Добавлено!
            a: Записано!
            a: Зафиксировано!!
            a: Done!
        

        script:
            addNote($parseTree._anyText, $context);
            addSuggestions(["Добавь задачу купить машину"], $context);