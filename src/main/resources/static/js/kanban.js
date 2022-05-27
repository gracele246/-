let note = document.getElementById("note-template");
const notes = document.getElementsByClassName("note")
let noteContainer = document.getElementById("nc-template");
var nCs = document.getElementsByClassName("noteContainer");
var nCTs = document.getElementsByClassName("noteContainerTitle");
const colContainer = document.getElementById("colContainer");

function addNote(self) {
    self.parentElement.parentElement.children[1].appendChild(note.content.firstElementChild.cloneNode(true));
}

function deleteNote(self) {
    self.parentElement.parentElement.parentElement.remove();


}

function addColumn() {
    colContainer.appendChild(noteContainer.content.firstElementChild.cloneNode(true))
    adjustColSize();
}

function deleteColumn(self) {
    self.parentElement.parentElement.remove();
    adjustColSize();



}