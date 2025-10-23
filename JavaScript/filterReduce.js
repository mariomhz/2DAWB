const pilots = [
  { id: 1, name: "Ryan Claudino da Costa", years: 21 },
  { id: 2, name: "Felipe Soares da Cruz", years: 25 },
  { id: 3, name: "Lucas Alano da Costa", years: 30 },
];


const pilotosInfo = pilots.map(p => `${p.name}, experiencia: ${p.years}`);
console.log(pilotosInfo);

const pilotosNombreYAnos = pilots.map(p => ({ name: p.name, years: p.years }));
console.log(pilotosNombreYAnos);

const pilotosExpertos = pilots.filter(p => p.years > 16);
console.log(pilotosExpertos);

const totalExperiencia = pilots.reduce((total, p) => total + p.years, 0);
console.log(totalExperiencia);

const pilotos15 = pilots.filter(p => p.years > 15).map(p => ({ name: p.name, id: p.id }));
console.log(pilotos15);

const pilotosInicialesJoin = pilots.map(p => ({
  id: p.id,
  iniciales: p.name.split(" ").map(word => word[0]).join("")
}));
console.log(pilotosInicialesJoin);

const pilotosInicialesReduce = pilots.map(p => ({
    id: p.id,
    iniciales: p.name.split(" ").reduce((acc, palabra) => acc + palabra[0], "")
}));
console.log(pilotosInicialesReduce);