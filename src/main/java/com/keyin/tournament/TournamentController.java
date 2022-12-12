package com.keyin.tournament;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequestMapping("api/tournaments")
@RestController
public class TournamentController {

    @Autowired
    private TournamentRepository repo;

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return (List<Tournament>) repo.findAll();
    }

    @PostMapping
    public void createTournament(@RequestBody Tournament tournament) {
        repo.save(tournament);
    }

    @PutMapping("{id}")
    public void updateTournament(@PathVariable String id, @RequestBody Tournament tournament, HttpServletResponse response) {
        Optional<Tournament> returnValue = repo.findById(Long.parseLong(id));
        Tournament tournamentToUpdate;

        if (returnValue.isPresent()) {
            tournamentToUpdate = returnValue.get();

            tournamentToUpdate.setCashPrizeAmount(tournament.getCashPrizeAmount());
            tournamentToUpdate.setLocation(tournament.getLocation());
            tournamentToUpdate.setEntryFee(tournament.getEntryFee());

            repo.save(tournamentToUpdate);
        } else {
            try {
                response.sendError(404, "Tournament with id: " + tournament.getId() + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @DeleteMapping(path = "{id}")
    public void deleteTournament(@PathVariable String id, HttpServletResponse response) {
        Optional<Tournament> returnValue = repo.findById(Long.parseLong(id));
        Tournament tournamentToDelete;

        if (returnValue.isPresent()) {
            tournamentToDelete = returnValue.get();

            repo.delete(tournamentToDelete);
        } else {
            try {
                response.sendError(404, "Tournament with id: " + id + " not found.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
